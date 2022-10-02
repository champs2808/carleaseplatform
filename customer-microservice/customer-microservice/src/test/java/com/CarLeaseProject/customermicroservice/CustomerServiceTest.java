package com.CarLeaseProject.customermicroservice;

import org.aspectj.lang.annotation.Before;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class CustomerServiceTest {



    @Before("")
    public void init() {
        MockitoAnnotations.initMocks(this);
    }

}
