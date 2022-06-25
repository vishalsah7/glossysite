package com.glossy.core.services.impl;

import com.glossy.core.services.EmployeeDetailsService;
import org.osgi.service.component.annotations.Component;

@Component(service = EmployeeDetailsService.class, immediate = true)
public class EmployeeDetailsServiceImpl1 implements EmployeeDetailsService {
    @Override
    public String getName() {
        return "Vishal";
    }

    @Override
    public String getAddress() {
        return "Anna Salai";
    }
}
