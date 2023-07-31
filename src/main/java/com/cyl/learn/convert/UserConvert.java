package com.cyl.learn.convert;

import com.cyl.learn.dataObject.UserDO;
import com.cyl.learn.domain.User;
import com.cyl.learn.response.UserResponseDto;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface UserConvert {
    UserConvert INSTANCE = Mappers.getMapper(UserConvert.class);

    UserResponseDto toResponse(User user);

    User toDomain(UserDO user);

    UserDO toDO(User user);

}
