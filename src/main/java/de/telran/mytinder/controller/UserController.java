package de.telran.mytinder.controller;
import de.telran.mytinder.entity.User;
import de.telran.mytinder.repository.UserRepositoryImpl;
import de.telran.mytinder.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController//создается контроллер и управляется спрингом
public class UserController {

    //@Autowired//находит юзерСервайс в контексте приложения и внедряет зависимость
    private final UserService userService;
    private final UserRepositoryImpl userRepositoryImpl;
    private int count = 1;

    public UserController(@Autowired @Qualifier(value = "topRatingUserService") UserService userService, @Autowired UserRepositoryImpl userRepositoryImpl) {
        this.userService = userService;
        this.userRepositoryImpl = userRepositoryImpl;
    }

    @GetMapping(value = "/show-new-user")
    public User showNewUser() {
        count++;
        return userService.getUser();
    }

//    @GetMapping(value = "/show-new-user")
//    public ResponseEntity<User> showNewUser() {
//        User user = userService.getUser();
//        count++;
//        return ResponseEntity.badRequest().build();
//        if (user != null){
//            return ResponseEntity.ok(user); //200
//        }
//        else {
//            return ResponseEntity.notFound().build(); //400
//        }
   // }


    @GetMapping(value = "/count")
    public int showCount(){
        return count;
    }

    @GetMapping(value = "/autocomplete/{name}")
    public List<User> getByName(@PathVariable(value = "name") String name) {
        return userService.getByName(name);
    }

    @PostMapping(value = "/save")
    public void save(@RequestBody User user){
        userService.save(user);
    }

    @GetMapping(value = "/show-user-by-rating")
    public List<User> getBetweenRatingValue(@RequestParam (name = "from") Integer from, @RequestParam(name = "to") Integer to){
        return userService.getBetweenRating(from, to);
    }

    @GetMapping(value = "/show-user-by-description")
    public List<User> getByDescription(@RequestParam(name = "text") String text){
        return userService.getUsersWithStringInDescription(text);
    }
    @GetMapping(value = "/show-user-by-description/count")
    public Integer getCountByDescription(@RequestParam(name = "text") String text){
        return userService.getCountUsersWithStringInDescription(text);
    }

    @GetMapping(value = "/is-user-exist/{id}")
    public Boolean isUserExist(@PathVariable(name = "id") Long id){
        return userService.existsUserById(id);
    }

    @GetMapping(value = "/show-all-users")
    public List<User> showPageOfUsers(@RequestParam(name = "site") Integer site, @RequestParam(name = "size") Integer size){
        Pageable pageable = PageRequest.of(site-1, size);
        return userService.findAll(pageable).getContent();
    }

}
