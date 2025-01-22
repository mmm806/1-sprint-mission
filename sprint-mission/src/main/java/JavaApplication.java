import com.sprint.mission.discodeit.entity.User;
import com.sprint.mission.discodeit.service.UserService;
import com.sprint.mission.discodeit.service.jcf.com.sprint.mission.discodeit.JCFUserService;

import java.util.List;
import java.util.Optional;
import java.util.UUID;


public class JavaApplication {
    public static void main(String[] args) {
        // UserService 인터페이스의 구현체 생성
        UserService userService = new JCFUserService();

        // 사용자 5명 등록
        System.out.println("=== User Registration ===");
        User user1 = userService.createUser("Alice", "alice@example.com");
        User user2 = userService.createUser("Bob", "bob@example.com");
        User user3 = userService.createUser("Charlie", "charlie@example.com");
        User user4 = userService.createUser("David", "david@example.com");
        User user5 = userService.createUser("Eve", "eve@example.com");

        // 등록된 사용자 출력
        System.out.println("Created users:");
        System.out.println(user1);
        System.out.println(user2);
        System.out.println(user3);
        System.out.println(user4);
        System.out.println(user5);

        // 단건 조회
        System.out.println("\n=== Single User Inquiry ===");
        UUID userId = user3.getId();
        User retrievedUser = userService.readUserById(userId);
        System.out.println("Retrieved user: " + (retrievedUser != null ? retrievedUser : "Not found"));

        // 전체 사용자 조회
        System.out.println("\n=== Look up all users ===");
        List<User> allUsers = userService.readAllUsers();
        System.out.println("All users:");
        allUsers.forEach(System.out::println);

        // 사용자 정보 수정
        System.out.println("\n=== Modifying User Information ===");
        userService.updateUser(user4.getId(), "David Brown", "david.brown@example.com");
        User updatedUser = userService.readUserById(user4.getId());
        System.out.println("Updated user: " + (updatedUser != null ? updatedUser : "Not found"));

        // 사용자 삭제
        System.out.println("\n=== Delete User ===");
        UUID deleteUserId = user5.getId();
        User userToDelete = userService.readUserById(deleteUserId);  // 삭제 전 사용자 조회
        System.out.println("User to be deleted: " + (userToDelete != null ? userToDelete : "Not found"));
        userService.deleteUser(deleteUserId);  // 사용자 삭제
        User deletedUserCheck = userService.readUserById(deleteUserId);  // 삭제 후 다시 조회
        System.out.println("Deleted user found: " + (deletedUserCheck != null ? deletedUserCheck : "Not found"));
    }
}
