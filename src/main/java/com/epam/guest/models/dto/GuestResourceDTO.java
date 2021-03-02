package com.epam.guest.models.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.*;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;


@Builder(toBuilder = true)
@Data
public class GuestResourceDTO {

    @ApiModelProperty(notes = "Guest Id")
    private Long guestId;

    @ApiModelProperty(notes = "first name", required = true)
    @NotNull(message = " first name should not be null")
    @NotEmpty(message = " first name should not be empty")
    private String firstName;

    @ApiModelProperty(notes = "last name", required = false)
    private String lastName;

    @ApiModelProperty(notes = "mobile number", required = true)
    @NotNull(message = " mobile number should not be null")
    @NotEmpty(message = " mobile number should not be empty")
    @Pattern(regexp = "\\d{10}", message = "mobile number is not valid")
    private Integer mobile;

    @ApiModelProperty(notes = " email id ", required = false)
    private String email;

    @ApiModelProperty(notes = "address", required = false)
    @Valid
    private AddressResourceDTO address;

}
