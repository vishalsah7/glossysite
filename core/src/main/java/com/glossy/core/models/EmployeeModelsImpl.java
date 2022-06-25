package com.glossy.core.models;

import com.glossy.core.models.services.EmployeeModelsService;
import com.glossy.core.services.EmployeeDetailsService;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.injectorspecific.OSGiService;

@Model(adaptables = Resource.class,
        adapters = EmployeeModelsService.class,
        resourceType = "glossysite/components/employeedetails",
        defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL)
public class EmployeeModelsImpl implements EmployeeModelsService{

    @OSGiService
    EmployeeDetailsService employeeDetailsService;

    @Override
    public String getEmployeeName() {
        return employeeDetailsService.getName();
    }

    @Override
    public String getEmployeeAddress() {
        return employeeDetailsService.getAddress();
    }
}
