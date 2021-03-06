package fi.vm.yti.codelist.common.dto;

import java.io.Serializable;
import java.util.Map;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonView;

import io.swagger.v3.oas.annotations.media.Schema;

@JsonFilter("valueType")
@XmlRootElement
@XmlType(propOrder = { "id", "url", "localName", "typeUri", "uri", "prefLabel", "regexp", "required" })
@Schema(name = "ValueType", description = "ValueType DTO for value typing.")
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class ValueTypeDTO extends AbstractIdentifyableCodeDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    private String url;
    private String localName;
    private String typeUri;
    private String uri;
    private Map<String, String> prefLabel;
    private String regexp;
    private boolean required;

    @JsonView(Views.Normal.class)
    public String getLocalName() {
        return localName;
    }

    public void setLocalName(final String localName) {
        this.localName = localName;
    }

    @JsonView(Views.Normal.class)
    public String getTypeUri() {
        return typeUri;
    }

    public void setTypeUri(final String typeUri) {
        this.typeUri = typeUri;
    }

    @JsonView(Views.Normal.class)
    public String getUri() {
        return uri;
    }

    public void setUri(final String uri) {
        this.uri = uri;
    }

    @JsonView(Views.Normal.class)
    public Map<String, String> getPrefLabel() {
        return prefLabel;
    }

    public void setPrefLabel(final Map<String, String> prefLabel) {
        this.prefLabel = prefLabel;
    }

    @JsonView(Views.Normal.class)
    public String getRegexp() {
        return regexp;
    }

    public void setRegexp(final String regexp) {
        this.regexp = regexp;
    }

    @JsonView(Views.Normal.class)
    public boolean getRequired() {
        return required;
    }

    public void setRequired(final boolean required) {
        this.required = required;
    }

    @JsonView(Views.Normal.class)
    public String getUrl() {
        return url;
    }

    public void setUrl(final String url) {
        this.url = url;
    }
}
