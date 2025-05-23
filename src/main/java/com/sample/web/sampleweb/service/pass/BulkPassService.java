package com.sample.web.sampleweb.service.pass;

import com.sample.web.sampleweb.controller.admin.BulkPassRequest;
import com.sample.web.sampleweb.repository.packaze.PackageEntity;
import com.sample.web.sampleweb.repository.packaze.PackageRepository;
import com.sample.web.sampleweb.repository.pass.BulkPassEntity;
import com.sample.web.sampleweb.repository.pass.BulkPassRepository;
import com.sample.web.sampleweb.repository.pass.BulkPassStatus;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class BulkPassService {
    private final BulkPassRepository bulkPassRepository;

    private final PackageRepository packageRepository;

    public BulkPassService(BulkPassRepository bulkPassRepository, PackageRepository packageRepository) {
        this.bulkPassRepository = bulkPassRepository;
        this.packageRepository = packageRepository;
    }

    public List<BulkPass> getAllBulkPasses() {
        List<BulkPassEntity> bulkPassEntities = bulkPassRepository.findAllOrderByStartedAtDesc();
        return BulkPassModelMapper.INSTANCE.map(bulkPassEntities);
    }

    public void addBulkPass(BulkPassRequest bulkPassRequest) {
        PackageEntity packageEntity = packageRepository.findById(bulkPassRequest.getPackageSeq()).orElseThrow();

        BulkPassEntity bulkPassEntity = BulkPassModelMapper.INSTANCE.map(bulkPassRequest);
        bulkPassEntity.setStatus(BulkPassStatus.READY);
        bulkPassEntity.setCount(packageEntity.getCount());
        bulkPassEntity.setEndedAt(packageEntity.getPeriod());

        bulkPassRepository.save(bulkPassEntity);
    }

}