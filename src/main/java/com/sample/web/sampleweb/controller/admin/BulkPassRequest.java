package com.sample.web.sampleweb.controller.admin;

import com.sample.web.sampleweb.util.LocalDateTimeUtils;
import java.time.LocalDateTime;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class BulkPassRequest {
    private Integer packageSeq;
    private String userGroupId;
    private LocalDateTime startedAt;

    public void setStartedAt(String startedAtString) {
        this.startedAt = LocalDateTimeUtils.parse(startedAtString);

    }

}