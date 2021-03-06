package fi.vm.yti.codelist.common.dto;

import java.time.LocalDate;

import javax.persistence.MappedSuperclass;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonView;

import io.swagger.v3.oas.annotations.media.Schema;

@MappedSuperclass
public class AbstractHistoricalCodeDTO extends AbstractCommonCodeDTO {

    private LocalDate startDate;
    private LocalDate endDate;
    private String status;

    @Schema(format = "date")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    @JsonView(Views.Normal.class)
    public LocalDate getStartDate() {
        if (startDate != null) {
            return startDate;
        }
        return null;
    }

    public void setStartDate(final LocalDate startDate) {
        if (startDate != null) {
            this.startDate = startDate;
        } else {
            this.startDate = null;
        }
    }

    @Schema(format = "date")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    @JsonView(Views.Normal.class)
    public LocalDate getEndDate() {
        if (endDate != null) {
            return endDate;
        }
        return null;
    }

    public void setEndDate(final LocalDate endDate) {
        if (endDate != null) {
            this.endDate = endDate;
        } else {
            this.endDate = null;
        }
    }

    @JsonView(Views.Normal.class)
    public String getStatus() {
        return status;
    }

    public void setStatus(final String status) {
        this.status = status;
    }
}
