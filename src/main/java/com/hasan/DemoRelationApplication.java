package com.hasan;

import com.hasan.entity.ERole;
import com.hasan.entity.Role;
import com.hasan.service.RoleService;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.PostConstruct;

@SpringBootApplication
@OpenAPIDefinition(info = @Info(title = "Demo Relation API", version = "3.0.0", description = "Relation Information"))
public class DemoRelationApplication {

    @Autowired
    private RoleService roleService;

    public static void main(String[] args) {
        SpringApplication.run(DemoRelationApplication.class, args);
    }


	@PostConstruct 												// If you want to run code-first,you should add this annotation.
	public void init(){

		if(roleService.findTopByName(ERole.ROLE_USER) == null) {
			Role role = new Role();
			role.setName(ERole.ROLE_USER);
			roleService.save(role);
		}
        if(roleService.findTopByName(ERole.ROLE_MODERATOR) == null) {
            Role role = new Role();
            role.setName(ERole.ROLE_MODERATOR);
            roleService.save(role);
        }
        if(roleService.findTopByName(ERole.ROLE_ADMIN) == null) {
            Role role = new Role();
            role.setName(ERole.ROLE_ADMIN);
            roleService.save(role);
        }

	}

}
