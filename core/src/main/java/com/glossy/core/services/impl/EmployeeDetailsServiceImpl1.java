package com.glossy.core.services.impl;

import com.glossy.core.services.DemoOsgiConfig;
import com.glossy.core.services.DemoOsgiFactoryConfig;
import com.glossy.core.services.EmployeeDetailsService;
import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.propertytypes.ServiceRanking;
import org.osgi.service.metatype.annotations.Designate;

import java.util.List;

@Component(service = EmployeeDetailsService.class, immediate = true)
//@ServiceRanking(101)
@Designate(ocd = DemoOsgiConfig.class)
public class EmployeeDetailsServiceImpl1 implements EmployeeDetailsService {
    private String name;
    private String implementation;
    private String address;
    @Activate
    protected void callOnActivation(DemoOsgiConfig demoOsgiConfig){
        name = demoOsgiConfig.getName();
        address = demoOsgiConfig.getAddress();
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
        return null;
    }

    public String getImplementation() {
        return "service implementation 1";
    }
}
