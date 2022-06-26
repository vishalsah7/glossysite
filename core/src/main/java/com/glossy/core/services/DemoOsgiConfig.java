package com.glossy.core.services;

import org.osgi.service.metatype.annotations.AttributeDefinition;
import org.osgi.service.metatype.annotations.AttributeType;
import org.osgi.service.metatype.annotations.ObjectClassDefinition;

@ObjectClassDefinition(name="Demo Osgi Config", description = "Demo Glossy Osgi config")
public @interface DemoOsgiConfig {

    @AttributeDefinition(name = "name",description = "name description", type = AttributeType.STRING)
    public String getName() default "vishal is the name";

    @AttributeDefinition(name = "address",description = "address description",type = AttributeType.STRING)
    public String getAddress() default "Anna salai is the address";
}
