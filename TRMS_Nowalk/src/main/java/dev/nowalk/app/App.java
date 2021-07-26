package dev.nowalk.app;

import dev.nowalk.controllers.DepartmentController;
import dev.nowalk.controllers.EmployeeController;
import dev.nowalk.controllers.EventController;
import dev.nowalk.controllers.GradingFormatController;
import dev.nowalk.controllers.RequestController;
import dev.nowalk.repositories.DepartmentRepo;
import dev.nowalk.repositories.DepartmentRepoImpl;
import dev.nowalk.repositories.EmployeeRepo;
import dev.nowalk.repositories.EmployeeRepoImpl;
import dev.nowalk.repositories.EventRepo;
import dev.nowalk.repositories.EventRepoImpl;
import dev.nowalk.repositories.EventTypeRepo;
import dev.nowalk.repositories.EventTypeRepoImpl;
import dev.nowalk.repositories.GradingFormatRepo;
import dev.nowalk.repositories.GradingFormatRepoImpl;
import dev.nowalk.repositories.RequestRepo;
import dev.nowalk.repositories.RequestRepoImpl;
import dev.nowalk.services.DepartmentServices;
import dev.nowalk.services.DepartmentServicesImpl;
import dev.nowalk.services.EmployeeServices;
import dev.nowalk.services.EmployeeServicesImpl;
import dev.nowalk.services.EventServices;
import dev.nowalk.services.EventServicesImpl;
import dev.nowalk.services.EventTypeServices;
import dev.nowalk.services.EventTypeServicesImpl;
import dev.nowalk.services.GradingFormatServices;
import dev.nowalk.services.GradingFormatServicesImpl;
import dev.nowalk.services.RequestServices;
import dev.nowalk.services.RequestServicesImpl;
import io.javalin.Javalin;

public class App {
	
	public static void main(String[] args) {
		
		Javalin app = Javalin.create(config -> config.enableCorsForAllOrigins());
		
		establishRoutes(app);
		
		app.start();
	}
	
	//My stack overflow error is from when I reference the employee as the department head
	private static void establishRoutes(Javalin app) {
		
		EmployeeRepo er = new EmployeeRepoImpl();
		RequestRepo rr = new RequestRepoImpl();
		DepartmentRepo dr = new DepartmentRepoImpl();
		GradingFormatRepo gfr = new GradingFormatRepoImpl();
		EventRepo evr = new EventRepoImpl();
		EventTypeRepo etr = new EventTypeRepoImpl();
		
		DepartmentServices ds = new DepartmentServicesImpl(dr);		
		RequestServices rs = new RequestServicesImpl(rr);
		EmployeeServices es = new EmployeeServicesImpl(er, rr);	
		GradingFormatServices gfs = new GradingFormatServicesImpl(gfr);
		EventServices evs = new EventServicesImpl(evr);
		EventTypeServices ets = new EventTypeServicesImpl(etr);
		
		DepartmentController dc = new DepartmentController(ds, es);		
		RequestController rc = new RequestController(rs, es, evs);
		EmployeeController ec = new EmployeeController(es, ds, rs);
		GradingFormatController gfc = new GradingFormatController(gfs);
		EventController evc = new EventController(evs, ets, gfs);
		
		//Employee routes
		app.get("/employees", ec.getAllEmployees);
		
		app.get("/employees/search?", ec.getEmployeeByName);
		
		app.get("/employees/:e_id", ec.getEmployeeById);
		
		app.post("/employees", ec.addEmployee);
		
		app.post("/employees/:name/requests", ec.submitNewRequest);
		
		app.patch("/employees/:e_name/departments/:d_name", ec.setDepartment);
		
		app.patch("/employees/:name/requests/:r_id", ec.submitNewRequest);
		
		app.patch("/employees/:e_id/ben_co/:bc_id", ec.setBenCoId);
		
		app.patch("/employees/:e_id/supervisors/:s_id", ec.setSuperId);
		
		app.get("/employees/:e_id/supervisors", ec.getAllEmployeesUnderSuper);
		
		app.get("/employees/:e_id/ben_co", ec.getAllEmployeesUnderBenCo);
		
		app.get("/employees/requests/:r_id", ec.getEmployeeByRequestId);
		
		
		//Department Routes
		app.get("/departments", dc.getAllDepartments);
		
		app.get("/departments/search?", dc.getDepartmentByname);
		
		app.get("/departments/:d_id", dc.getDepartmentById);
		
		app.post("/departments", dc.addDepartment);
		
		app.put("/departments/:d_id", dc.updateDepartment);
		
		app.patch("/departments/:d_name/employees/:e_name", dc.setDepartmentHead);
		
		//request routes
		//I want this request to come from the employee, not the request itself
		app.post("/requests", rc.addRequest);
		
		app.patch("/events/:e_id/requests/:r_id", rc.addEventToRequest);
		
		app.patch("/requests/:r_id/ben_co_approvals", rc.setBenCoApproval);
		
		app.patch("/requests/:r_id/dep_head_approvals", rc.setDepHeadApproval);
		
		app.patch("/requests/:r_id/super_approvals", rc.setSuperApproval);
		
		app.patch("/requests/:r_id/is_urgent", rc.setIsUrgent);
		
		app.get("/requests", rc.getAllRequests);
		
		app.get("/requests/employees/:e_id", rc.getAllRequestsByEmployee);
		
		app.get("/requests/:r_id", rc.getRequestById);
		
		//grading format routes, won't be used much
		
		app.post("/grading_formats", gfc.addGradingFormat);
		
		app.get("/grading_formats", gfc.getAllGradingFormats);
		
		//app.get("/grading_formats/:gf_id", gfc.getGradingFormatById);
		
		app.get("/grading_formats/search?", gfc.getGradingFormatByType);
		
		app.put("/grading_formats", gfc.updateGradingFormat);
		
		app.delete("/grading_formats", gfc.deleteGradingFormat);
		
		//Event routes
		
		app.post("/events", evc.addEvent);
		
		app.get("/events", evc.getAllEvents);
		
		app.get("/events/:event_name", evc.getEventByName);
		
		app.patch("/events/:ev_id/event_types/:et_id", evc.addEventTypeToEvent);
		
		app.patch("/events/:ev_id/grading_formats/:gf_id", evc.addGradingFormatToEvent);
	}
	
}
