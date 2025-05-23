package com.sample.web.sampleweb.service.pass;


import com.sample.web.sampleweb.repository.pass.PassEntity;
import java.util.List;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface PassModelMapper {
    PassModelMapper INSTANCE = Mappers.getMapper(PassModelMapper.class);

    @Mapping(target = "packageName", source = "packageEntity.packageName")
    Pass map(PassEntity passEntity);

    List<Pass> map(List<PassEntity> passEntities);

}
