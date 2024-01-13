package de.telran.mytinder.service.impl;

import de.telran.mytinder.entity.User;
import de.telran.mytinder.repository.PhotoRepository;
import de.telran.mytinder.repository.UserRepository;
import jakarta.inject.Inject;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class TopRatingUserServiceTest {
    @Mock
    private UserRepository userRepository;
    @Mock
    private PhotoRepository photoRepository;

    @InjectMocks
    private TopRatingUserService topRatingUserService;

    @Test
    public void test() {
        User first = new User(33L, "Petr", 100, "Just Petr");
        User second = new User(36L, "Ivan", 200, "Just Ivan");

        List<User> users = new ArrayList<>();

        users.add(first);
        users.add(second);
        // задание начальных значений
        when(userRepository.findAll()).thenReturn(users);

        // запустить сам метод
        User user = topRatingUserService.getUser();

        // проверка результата
        assertEquals(second, user);
        verify(userRepository, times(1)).findAll(); // сколько раз вызывался метод
    }

    @Test
    public void getByName_NameDaniil_success() {
        User first = new User(38L, "Daniil Tkachenko", 100, "Just Petr");
        User second = new User(37L, "Daniil Petrov", 200, "Just Ivan");

        List<User> users = new ArrayList<>();

        users.add(first);
        users.add(second);
        // задание начальных значений
        when(userRepository.findAutocomplete3(anyString())).thenReturn(users);

        // запустить сам метод
        List<User> userList = topRatingUserService.getByName("Daniil");

        // проверка результата
        assertEquals(2, userList.size());
    }

}