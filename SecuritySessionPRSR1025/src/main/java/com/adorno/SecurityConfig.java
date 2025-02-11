package com.adorno;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.session.SessionRegistry;
import org.springframework.security.core.session.SessionRegistryImpl;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
	
	@Bean
	public SessionRegistry createSessionRegistry() {
		return new SessionRegistryImpl();
	}

	@Bean
	SecurityFilterChain getFilterChain(HttpSecurity httpSecurity) throws Exception {
		return httpSecurity
				.authorizeHttpRequests(auth -> {// permitir solo a los identificados
						auth.anyRequest().authenticated();
						})
				.formLogin(login -> login.permitAll())
				.sessionManagement((session)->{
					// hay varios tipos

					// always siempre que no hay una session existente la creara, si la hay la
					// reutiliza
					session.sessionCreationPolicy(SessionCreationPolicy.ALWAYS);
					// crea una session si es necesario si no hay session la crea
					// hacen casi lo mismo. este es mas restrictivo(?) evalua si hace falta crear la
					// sesion
					// sess.sessionCreationPolicy(SessionCreationPolicy.IF_REQUIRED);
					// no creamos sesiones pero reutiliza las que haya
					// sess.sessionCreationPolicy(SessionCreationPolicy.NEVER);
					// no crea ni reutiliza. Todas las peticiones son atomicas
					// sess.sessionCreationPolicy(SessionCreationPolicy.STATELESS);
					// las sesiones permiten almacenar informacion sobre el usuario, en esa session
					/*
					 * Aquii podemos decir por defecto la uri a la que vamos si no se crea bien la
					 * session
					 */
					session.invalidSessionUrl("/login");
					/*
					 * Cuantas sesiones a la vez? una o varias dependera del servidor
					 */
					session.maximumSessions(1).sessionRegistry(createSessionRegistry());
					// Es una vulnerabilidad con las sesiones
					session.sessionFixation()
					// ante un ataque genera otro id. y copiar los datos de la sesion a la nueva
					// sesion
//					.migrateSession();
					// igual que la anterior sin migrar los datos
//					.newSession()
					// no hacer nada (????!!!!) deshabilitamos este escudo
					.none();
				})
				.build();
		}
	}
