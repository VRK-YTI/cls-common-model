package fi.vm.yti.codelist.common.dto;

import java.io.Serializable;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonView;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import static fi.vm.yti.codelist.common.constants.ApiConstants.LANGUAGE_CODE_EN;

@JsonFilter("member")
@XmlRootElement
@XmlType(propOrder = { "id", "url", "code", "prefLabel", "created", "modified", "startDate", "endDate", "memberValue_1", "memberValue_2", "memberValue_3", "order", "extension", "relatedMember" })
@ApiModel(value = "Member", description = "Member DTO that represents data for one member element.")
@JsonIgnoreProperties(value = { "expanded" })
public class MemberDTO extends AbstractIdentifyableCodeDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer order;
    private CodeDTO code;
    private ExtensionDTO extension;
    private MemberDTO relatedMember;
    private Date created;
    private Date modified;
    private String url;
    private Map<String, String> prefLabel;
    private Date startDate;
    private Date endDate;
    private String memberValue_1;
    private String memberValue_2;
    private String memberValue_3;

    @JsonView(Views.Normal.class)
    public String getUrl() {
        return url;
    }

    public void setUrl(final String url) {
        this.url = url;
    }

    @ApiModelProperty(dataType = "dateTime")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss.SSSX")
    @JsonView(Views.Normal.class)
    public Date getModified() {
        if (modified != null) {
            return new Date(modified.getTime());
        }
        return null;
    }

    public void setModified(final Date modified) {
        if (modified != null) {
            this.modified = new Date(modified.getTime());
        } else {
            this.modified = null;
        }
    }

    @ApiModelProperty(dataType = "dateTime")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss.SSSX")
    @JsonView(Views.Normal.class)
    public Date getCreated() {
        if (created != null) {
            return new Date(created.getTime());
        }
        return null;
    }

    public void setCreated(final Date created) {
        if (created != null) {
            this.created = new Date(created.getTime());
        } else {
            this.created = null;
        }
    }

    @JsonView(Views.Normal.class)
    public Integer getOrder() {
        return order;
    }

    public void setOrder(final Integer order) {
        this.order = order;
    }

    @JsonView(Views.ExtendedMember.class)
    public CodeDTO getCode() {
        return code;
    }

    public void setCode(final CodeDTO code) {
        this.code = code;
    }

    @JsonView(Views.ExtendedMember.class)
    public ExtensionDTO getExtension() {
        return extension;
    }

    public void setExtension(final ExtensionDTO extension) {
        this.extension = extension;
    }

    @JsonView(Views.ExtendedMember.class)
    public MemberDTO getRelatedMember() {
        return relatedMember;
    }

    public void setRelatedMember(final MemberDTO relatedMember) {
        this.relatedMember = relatedMember;
    }

    @JsonView(Views.Normal.class)
    public Map<String, String> getPrefLabel() {
        return prefLabel;
    }

    public void setPrefLabel(final Map<String, String> prefLabel) {
        this.prefLabel = prefLabel;
    }

    public String getPrefLabel(final String language) {
        String prefLabelValue = this.prefLabel.get(language);
        if (prefLabelValue == null) {
            prefLabelValue = this.prefLabel.get(LANGUAGE_CODE_EN);
        }
        return prefLabelValue;
    }

    public void setPrefLabel(final String language,
                             final String value) {
        if (this.prefLabel == null) {
            this.prefLabel = new HashMap<>();
        }
        if (language != null && value != null && !value.isEmpty()) {
            this.prefLabel.put(language, value);
        } else if (language != null) {
            this.prefLabel.remove(language);
        }
        setPrefLabel(this.prefLabel);
    }

    @ApiModelProperty(dataType = "dateTime")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    @JsonView(Views.Normal.class)
    public Date getStartDate() {
        if (startDate != null) {
            return new Date(startDate.getTime());
        }
        return null;
    }

    public void setStartDate(final Date startDate) {
        if (startDate != null) {
            this.startDate = new Date(startDate.getTime());
        } else {
            this.startDate = null;
        }
    }

    @ApiModelProperty(dataType = "dateTime")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    @JsonView(Views.Normal.class)
    public Date getEndDate() {
        if (endDate != null) {
            return new Date(endDate.getTime());
        }
        return null;
    }

    public void setEndDate(final Date endDate) {
        if (endDate != null) {
            this.endDate = new Date(endDate.getTime());
        } else {
            this.endDate = null;
        }
    }

    @JsonView(Views.Normal.class)
    public String getMemberValue_1() {
        return memberValue_1;
    }

    public void setMemberValue_1(final String memberValue_1) {
        this.memberValue_1 = memberValue_1;
    }

    @JsonView(Views.Normal.class)
    public String getMemberValue_2() {
        return memberValue_2;
    }

    public void setMemberValue_2(final String memberValue_2) {
        this.memberValue_2 = memberValue_2;
    }

    @JsonView(Views.Normal.class)
    public String getMemberValue_3() {
        return memberValue_3;
    }

    public void setMemberValue_3(final String memberValue_3) {
        this.memberValue_3 = memberValue_3;
    }
}