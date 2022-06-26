package com.glossy.core.services.impl;

import com.glossy.core.services.DemoOsgiConfig;
import com.glossy.core.services.DemoOsgiFactoryConfig;
import com.glossy.core.services.EmployeeDetailsService;
import org.osgi.service.component.annotations.*;
import org.osgi.service.metatype.annotations.Designate;

import java.util.ArrayList;
import java.util.List;

@Component(service = EmployeeDetailsService.class, immediate = true, name = "service3")
@Designate(ocd = DemoOsgiFactoryConfig.class, factory = true)
public class EmployeeDetailsFactoryServiceImpl implements EmployeeDetailsService {

    private String name;
    private String implementation;
    private String address;
    List<EmployeeDetailsService> employeeDetailsServiceList;

    @Activate
    @Modified
    protected void callOnActivation(DemoOsgiFactoryConfig demoOsgiFactoryConfig){
        name = demoOsgiFactoryConfig.getName();
        address = demoOsgiFactoryConfig.getAddress();
    }

    @Reference(service = EmployeeDetailsService.class, cardinality = ReferenceCardinality.MULTIPLE, policy = ReferencePolicy.DYNAMIC)
    public void bindEmployeeDetailsService(final EmployeeDetailsService employeeDetailsService) {
        if (employeeDetailsServiceList == null) {
            employeeDetailsServiceList = new ArrayList<>();
        }
        employeeDetailsServiceList.add(employeeDetailsService);
    }

    public void unbindEmployeeDetailsService(final EmployeeDetailsService employeeDetailsService) {
        if (employeeDetailsServiceList != null) {
            employeeDetailsServiceList.remove(employeeDetailsService);
        }

    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getAddress() {
        return address;
    }

    @Override
    public List<EmployeeDetailsService> getEmployeeDetailsService() {
        return employeeDetailsServiceList;
    }

}
