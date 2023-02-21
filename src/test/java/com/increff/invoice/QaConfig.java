package com.increff.invoice;

import com.increff.invoice.spring.SpringConfig;
import org.springframework.context.annotation.*;
import org.springframework.context.annotation.ComponentScan.Filter;

@Configuration
@ComponentScan(//
		basePackages = {"com.increff.invoice"}, //
		excludeFilters = @Filter(type = FilterType.ASSIGNABLE_TYPE, value = { SpringConfig.class })//
)
@PropertySources({ //
		@PropertySource(value = "classpath:./com/increff/invoice/test.properties", ignoreResourceNotFound = true) //
})
public class QaConfig {


}
