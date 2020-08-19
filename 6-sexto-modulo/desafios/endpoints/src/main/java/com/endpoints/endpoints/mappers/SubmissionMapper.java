package com.endpoints.endpoints.mappers;

import com.endpoints.endpoints.dto.SubmissionDTO;
import com.endpoints.endpoints.entity.Submission;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring")
public interface SubmissionMapper {

    @Mappings({
            @Mapping(source = "id.user.id", target = "userId"),
            @Mapping(source = "id.challenge.id", target = "challengeId"),
            @Mapping(source = "createdAt", target = "createdAt", dateFormat = "yyyy-MM-dd HH:mm"),
            @Mapping(source = "score", target = "score"),
    })
    SubmissionDTO map(Submission submission);

    List<SubmissionDTO> map(List<Submission> submissions);

}
