package hr.main;

import hr.logging.ConsoleLogger;
import hr.persistence.EmployeeRepository;
import hr.personnel.Employee;
import hr.persistence.EmployeeFileSerializer;

import java.io.IOException;
import java.util.List;

public class SaveEmployeesMain {
    public static void main(String[] args) {

        EmployeeFileSerializer serializer = new EmployeeFileSerializer();
        ConsoleLogger logger = new ConsoleLogger();


        // Grab employees
        EmployeeRepository repository = new EmployeeRepository(serializer);
        List<Employee> employees = repository.findAll();

        // Save all
        for (Employee e : employees){
            try {
                repository.save(e);

                logger.writeMessage("Saved employee " + e.toString());

            } catch (IOException exception) {
                logger.writeError("ERROR: Could not save employee. " , exception);
            }
        }
    }
}
