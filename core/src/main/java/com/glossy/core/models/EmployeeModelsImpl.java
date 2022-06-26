package com.glossy.core.models;

import com.glossy.core.services.DemoOsgiFactoryConfig;
import com.glossy.core.services.EmployeeDetailsService;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.injectorspecific.OSGiService;

import java.util.ArrayList;
import java.util.List;

@Model(adaptables = Resource.class, adapters = EmployeeModelsService.class, resourceType = "glossysite/components/employeedetails", defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL)
public class EmployeeModelsImpl implements EmployeeModelsService {

    //@OSGiService
    @OSGiService(filter = "(component.name=service2)")
    EmployeeDetailsService employeeDetailsService;

    @OSGiService(filter = "(component.name=service3)")
    EmployeeDetailsService employeeDetailsService3;

    @Override
    public String getEmployeeName() {
        return employeeDetailsService.getName();
    }

    @Override
    public String getEmployeeAddress() {
        return employeeDetailsService.getAddress();
    }

    @Override
    public List<String> getOsgiConfigsList() {
        List<String> employeeName = new ArrayList<>();
        if (employeeDetailsService3 != null) {
            for (EmployeeDetailsService employeeDetailsService : employeeDetailsService3.getEmployeeDetailsService()) {
                employeeName.add(employeeDetailsService.getName());
            }
        }
        return employeeName;
    }
}
