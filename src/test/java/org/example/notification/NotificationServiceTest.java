package org.example.notification;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

class NotificationServiceTest {

    @Mock
    private NotificationRepository notificationRepository;

    @InjectMocks
    private NotificationService notificationService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void sendNotificationSuccessReturnTrue() {

        String message = "hola";
        when(notificationRepository.send(anyString())).thenReturn(Boolean.TRUE);

        boolean result = notificationService.sendNotification(message);

        assertTrue(result);
        verify(notificationRepository, times(1)).send(message);
    }

    @Test
    void sendNotificationIsNullReturnFalse() {

        boolean result = notificationService.sendNotification(null);

        assertFalse(result);

        verify(notificationRepository, times(0)).send(any(String.class));
    }

    @Test
    void sendNotificationIsEmptyReturnFalse() {

        boolean result = notificationService.sendNotification("");

        assertFalse(result);

        verify(notificationRepository, times(0)).send(any(String.class));
    }
}