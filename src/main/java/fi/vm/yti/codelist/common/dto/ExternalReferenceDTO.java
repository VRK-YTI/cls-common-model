package fi.vm.yti.codelist.common.dto;

import java.io.Serializable;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonView;

import io.swagger.v3.oas.annotations.media.Schema;
import static fi.vm.yti.codelist.common.constants.ApiConstants.LANGUAGE_CODE_EN;

@JsonFilter("externalReference")
@XmlRootElement
@XmlType(propOrder = { "id", "url", "created", "modified", "href", "global", "title", "description", "parentCodeScheme", "codes", "codeSchemes" })
@Schema(name = "ExternalReference", description = "ExternalReference DTO that represents data for either CodeScheme or Code related external link.")
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class ExternalReferenceDTO extends AbstractIdentifyableCodeDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    private Map<String, String> title;
    private Map<String, String> description;
    private Set<CodeSchemeDTO> codeSchemes;
    private Set<CodeDTO> codes;
    private PropertyTypeDTO propertyType;
    private CodeSchemeDTO parentCodeScheme;
    private Boolean global;
    private String href;
    private Date created;
    private Date modified;
    private String url;

    @Schema(format = "dateTime")
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

    @Schema(format = "dateTime")
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

    @JsonView(Views.Normal.class)
    public String getUrl() {
        return url;
    }

    public void setUrl(final String url) {
        this.url = url;
    }

    public Boolean getGlobal() {
        return global;
    }

    public void setGlobal(final Boolean global) {
        this.global = global;
    }

    @JsonView(Views.Normal.class)
    public Map<String, String> getTitle() {
        if (title == null) {
            title = new HashMap<>();
        }
        return title;
    }

    public void setTitle(final Map<String, String> title) {
        this.title = title;
    }

    public String getTitle(final String language) {
        String titleValue = null;
        if (this.title != null && !this.title.isEmpty()) {
            titleValue = this.title.get(language);
            if (titleValue == null) {
                titleValue = this.title.get(LANGUAGE_CODE_EN);
            }
        }
        return titleValue;
    }

    public void setTitle(final String language,
                         final String value) {
        if (title == null) {
            title = new HashMap<>();
        }
        if (language != null && value != null && !value.isEmpty()) {
            title.put(language, value);
        } else if (language != null) {
            title.remove(language);
        }
        setTitle(title);
    }

    @JsonView(Views.Normal.class)
    public Map<String, String> getDescription() {
        if (description == null) {
            description = new HashMap<>();
        }
        return description;
    }

    public void setDescription(final Map<String, String> description) {
        this.description = description;
    }

    public String getDescription(final String language) {
        String descriptionValue = null;
        if (this.description != null && !this.description.isEmpty()) {
            descriptionValue = this.description.get(language);
            if (descriptionValue == null) {
                descriptionValue = this.description.get(LANGUAGE_CODE_EN);
            }
        }
        return descriptionValue;
    }

    public void setDescription(final String language,
                               final String value) {
        if (description == null) {
            description = new HashMap<>();
        }
        if (language != null && value != null && !value.isEmpty()) {
            description.put(language, value);
        } else if (language != null) {
            description.remove(language);
        }
        setDescription(description);
    }

    @JsonView(Views.ExtendedExternalReference.class)
    public Set<CodeSchemeDTO> getCodeSchemes() {
        return this.codeSchemes;
    }

    public void setCodeSchemes(final Set<CodeSchemeDTO> codeSchemes) {
        this.codeSchemes = codeSchemes;
    }

    @JsonView(Views.ExtendedExternalReference.class)
    public Set<CodeDTO> getCodes() {
        return this.codes;
    }

    public void setCodes(final Set<CodeDTO> codes) {
        this.codes = codes;
    }

    @JsonView(Views.Normal.class)
    public PropertyTypeDTO getPropertyType() {
        return propertyType;
    }

    public void setPropertyType(final PropertyTypeDTO propertyType) {
        this.propertyType = propertyType;
    }

    @JsonView(Views.ExtendedExternalReference.class)
    public CodeSchemeDTO getParentCodeScheme() {
        return parentCodeScheme;
    }

    public void setParentCodeScheme(final CodeSchemeDTO codeScheme) {
        this.parentCodeScheme = codeScheme;
    }

    public String getHref() {
        return href;
    }

    @JsonView(Views.Normal.class)
    public void setHref(final String href) {
        this.href = href;
    }
}
