package az.glamouserservice.mapper;

import az.glamouserservice.dao.entity.UserEntity;
import az.glamouserservice.model.request.UserRequest;
import az.glamouserservice.model.response.UserResponse;

public enum UserMapper {
    USER_MAPPER;

    public UserEntity buildUserEntity(UserRequest userRequest){
        return UserEntity.builder()
                .fullName(userRequest.getFullName())
                .email(userRequest.getEmail())
                .phone(userRequest.getPhone())
                .role(userRequest.getRole())
                .build();
    }


    public UserResponse buildUserResponse(UserEntity userEntity){
       return UserResponse.builder()
                .id(userEntity.getId())
                .fullName(userEntity.getFullName())
                .email(userEntity.getEmail())
                .phone(userEntity.getPhone())
                .role(userEntity.getRole())
                .createdAt(userEntity.getCreatedAt())
                .updatedAt(userEntity.getUpdatedAt())
                .build();
    }
}

