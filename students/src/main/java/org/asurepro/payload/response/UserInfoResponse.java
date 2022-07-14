package org.asurepro.payload.response;

import lombok.*;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class UserInfoResponse {
	private Long id;
	private String username;
	private String email;
	private List<String> roles;
}
