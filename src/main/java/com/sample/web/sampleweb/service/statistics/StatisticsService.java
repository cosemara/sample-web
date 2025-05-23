package com.sample.web.sampleweb.service.statistics;

import com.sample.web.sampleweb.repository.statistics.StatisticsRepository;
import com.sample.web.sampleweb.util.LocalDateTimeUtils;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class StatisticsService {

    private final StatisticsRepository statisticsRepository;

    public StatisticsService(StatisticsRepository statisticsRepository) {
        this.statisticsRepository = statisticsRepository;
    }

    public ChartData makeChartData(final LocalDateTime to) {
        final LocalDateTime from = to.minusDays(10);

        final List<AggregatedStatistics> aggregatedStatisticsList = statisticsRepository.findByStatisticsAtBetweenAndGroupBy(from, to);
        List<String> labels = new ArrayList<>();
        List<Long> attendedCounts = new ArrayList<>();
        List<Long> cancelledCounts = new ArrayList<>();

        for (AggregatedStatistics statistics : aggregatedStatisticsList) {
            labels.add(LocalDateTimeUtils.format(statistics.getStatisticsAt(), LocalDateTimeUtils.MM_DD));
            attendedCounts.add(statistics.getAttendedCount());
            cancelledCounts.add(statistics.getCancelledCount());
        }
        return new ChartData(labels, attendedCounts, cancelledCounts);

    }
}