package mycode.employee.app.exceptions;

import mycode.employee.app.constants.Constants;

public class NoEmployeeFound extends RuntimeException {
    public NoEmployeeFound(String message) {
        super(message);
      System.out.println(Constants.NO_EMPLOYEE_FOUND);
    }
}
