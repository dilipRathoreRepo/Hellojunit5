package org.example;

import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.when;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class GreetingImplTest {

    @Mock
    private GreetingService service;

    @InjectMocks
    private GreetingImpl greeting;

    @Test
    public void greetShouldReturnValidOutput() {
        String val = "Junit";
        when(service.greet(val)).thenReturn("Hello " + val);
        String result = greeting.greet(val);

        Assertions.assertNotNull(result);
        Assertions.assertEquals(result, "Hello Junit");
    }

    @Test
    public void greetShouldThrowIllegalArgumentExceptionForNameAsBlank() {
        doThrow(IllegalArgumentException.class).when(service).greet("");
        Assertions.assertThrows(IllegalArgumentException.class, () -> greeting.greet(""));
    }

    @Test
    public void greetShouldThrowIllegalArgumentExceptionForNameAsNull() {
        when(service.greet(null)).thenThrow(IllegalArgumentException.class);
        Assertions.assertThrows(IllegalArgumentException.class, () -> greeting.greet(null));

    }

}