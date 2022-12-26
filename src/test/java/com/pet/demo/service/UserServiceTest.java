//package com.pet.demo.service;
//
//import com.pet.demo.dto.UserDTO;
//import com.pet.demo.entity.User;
//import com.pet.demo.exception.EntityNotFoundException;
//import com.pet.demo.mappers.UserMapper;
//import com.pet.demo.repository.RoleRepository;
//import com.pet.demo.repository.UserRepository;
//import org.junit.jupiter.api.Assertions;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//import org.junit.jupiter.api.extension.ExtendWith;
//import org.mockito.Mock;
//import org.mockito.junit.jupiter.MockitoExtension;
//
//import javax.validation.Validator;
//import java.util.Optional;
//
//import static org.junit.jupiter.api.Assertions.assertEquals;
//import static org.mockito.Mockito.when;
//
//@ExtendWith(MockitoExtension.class)
//class UserServiceTest {
//
//    @Mock
//    private UserRepository userRepository;
//
//    @Mock
//    private RoleRepository roleRepository;
//
//    @Mock
//    private UserMapper userMapper;
//
//    @Mock
//    private UserService userService;
//
//    @Mock
//    private Validator validate;
//
//
//    @BeforeEach
//    void init() {
//        userService = new UserService(userRepository, userMapper);
//    }
//
//    @Test
//    void testSave() {
////        User user = new User();
////        User savedUser = new User();
////        Long userId = 1L;
////        savedUser.setId(userId);
////        UserInsertRequest userInsertRequest = new UserInsertRequest();
////        UserDTO userDto = new UserDTO();
////        userDto.setId(userId);
////
////        when(userMapper.sourceToDestination(userInsertRequest)).thenReturn(user);
////
////        when(userRepository.save(user)).thenReturn(savedUser);
////        when(userMapper.destinationToSource(savedUser)).thenReturn(userDto);
////        UserDTO actualResult = userService.save(userInsertRequest);
////
////        assertEquals(userDto, actualResult);
//    }
//
//    @Test
//    void testFindById() {
//        User user = new User();
//        Long userId = 1L;
//
//        UserDTO userDto = new UserDTO();
//        userDto.setId(userId);
//
//        Optional<User> userOptional = Optional.of(user);
//        when(userRepository.findById(1L)).thenReturn(userOptional);
//        when(userMapper.destinationToSource(user)).thenReturn(userDto);
//
//        UserDTO actualResult = userService.findByName(1L);
//
//        assertEquals(userDto, actualResult);
//    }
//
//    @Test
//    void testFindById_ThrowException() {
////        Long notExistingUserId = 1L;
////        when(userRepository.findById(notExistingUserId)).thenReturn(Optional.empty());
////
////        EntityNotFoundException thrown = Assertions.assertThrows(
////                EntityNotFoundException.class,
////                () -> userService.findById(notExistingUserId));
////
////        Assertions.assertEquals(String.format("User with Id %d not found", notExistingUserId), thrown.getMessage());
//    }
//
//    @Test
//    void testFindByName() {
//        User user = new User();
//        String name = "name";
//
//        UserDTO userDto = new UserDTO();
//        userDto.setUsername(name);
//
//        Optional<User> userOptional = Optional.of(user);
//        when(userRepository.findByUsername(name)).thenReturn(userOptional);
//        when(userMapper.destinationToSource(user)).thenReturn(userDto);
//
//        UserDTO actualResult = userService.findByName(name);
//
//        assertEquals(userDto, actualResult);
//    }
//
//    @Test
//    void testFindByName_ThrowException() {
//        String notExistingUserName = "userName";
//        when(userRepository.findByUsername(notExistingUserName)).thenReturn(Optional.empty());
//
//        EntityNotFoundException thrown = Assertions.assertThrows(
//                EntityNotFoundException.class,
//                () -> userService.findByName(notExistingUserName));
//
////        Assertions.assertEquals(String.format("User with name %s not found", notExistingUserName), thrown.getMessage());
//    }
//
//    @Test
//    void testDeleteById() {
//        Long userId = 1L;
//        User user = new User();
//        user.setId(userId);
//
//        UserDTO userDto = new UserDTO();
//        userDto.setId(userId);
//        Optional<User> userOptional = Optional.of(user);
//
//        when(userRepository.findById(userId)).thenReturn(userOptional);
//        when(userMapper.destinationToSource(user)).thenReturn(userDto);
//
////        UserDTO actualResult = userService.delete(userId);
////        assertEquals(userDto, actualResult);
//    }
//
//    @Test
//    void testEdit() {
////        Long userId = 1L;
////        UserEditRequest userEditRequest = new UserEditRequest();
////        User userToUpdate = new User();
////        userToUpdate.setId(userId);
////        User userUpdater = new User();
////        userUpdater.setId(userId);
////        UserDTO userDto = new UserDTO();
////        userDto.setId(userId);
////
////        when(userRepository.findById(userId)).thenReturn(Optional.of(userToUpdate));
////        when(userMapper.sourceToDestination(userEditRequest)).thenReturn(userUpdater);
////        when(userRepository.save(userToUpdate)).thenReturn(userToUpdate);
////        when(userMapper.destinationToSource(userToUpdate)).thenReturn(userDto);
////
////        UserDTO actualResult = userService.edit(userEditRequest, userId);
////
////        verify(userMapper, times(1)).update(userToUpdate, userUpdater);
////        verify(userRepository, times(1)).save(userToUpdate);
////
////        assertEquals(userDto, actualResult);
//    }
//}