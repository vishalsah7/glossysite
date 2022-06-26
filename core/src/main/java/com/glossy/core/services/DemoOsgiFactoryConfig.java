package com.glossy.core.services;

import org.osgi.service.metatype.annotations.AttributeDefinition;
import org.osgi.service.metatype.annotations.ObjectClassDefinition;

@ObjectClassDefinition(name = "DEMO OSGI FACTORY ", description = "DEMO OSGI FACTORY description")
public @interface DemoOsgiFactoryConfig {

    @AttributeDefinition(name = "name", description = "address")
    public String getName() default "vishal";

    @AttributeDefinition(name = "address", description = "address")
    public String getAddress() default "Anna salai";
}
