package com.epam.guest.api;

import com.epam.guest.models.dto.GuestResourceDTO;
import io.swagger.annotations.*;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * The interface Guest api.
 */
@Api(value = "guest")
@RequestMapping("guest")
public interface GuestApi {

    /**
     * Gets guest information.
     *
     * @param guestId the guest id
     * @return the guest information
     */
    @ApiOperation(
            value = "Fetch Guest Information ",
            response = GuestResourceDTO.class,
            produces = MediaType.APPLICATION_JSON_VALUE,
            httpMethod = "GET"
    )
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Success|OK", response = GuestResourceDTO.class),
            @ApiResponse(code = 401, message = "not authorized!"),
            @ApiResponse(code = 403, message = "forbidden!!!"),
            @ApiResponse(code = 404, message = "Guest Information not found!!!")})

    @GetMapping(value = "/getGuest/{guestId}")
    @ResponseBody
    ResponseEntity<GuestResourceDTO> getGuestInformation(@ApiParam(value = "guest id to get guest information") @PathVariable final Long guestId);

    /**
     * Add guest response entity.
     *
     * @param guestDetailsRequest the guest details request
     * @return the response entity
     */
    @ApiOperation(
            value = "Request for adding a new guest information",
            response = GuestResourceDTO.class,
            consumes = MediaType.APPLICATION_JSON_VALUE,
            httpMethod = "POST"
    )
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Success|OK",  response = GuestResourceDTO.class),
            @ApiResponse(code = 401, message = "not authorized!"),
            @ApiResponse(code = 403, message = "forbidden!!!"),
            @ApiResponse(code = 404, message = "not found!!!")})
    @RequestMapping(value = "/addGuest")
    ResponseEntity<GuestResourceDTO> addGuest(
            @ApiParam(value = "request for adding a new Guest") @RequestBody final GuestResourceDTO guestDetailsRequest);

    /**
     * Delete guest response entity.
     *
     * @param guestId the guest id
     * @return the response entity
     */
    @ApiOperation(
            value = "Request for deleting the guest information",
            response = GuestResourceDTO.class,
            consumes = MediaType.APPLICATION_JSON_VALUE,
            httpMethod = "DELETE"
    )
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Success|OK",  response = GuestResourceDTO.class),
            @ApiResponse(code = 401, message = "not authorized!"),
            @ApiResponse(code = 403, message = "forbidden!!!"),
            @ApiResponse(code = 404, message = "not found!!!")})
    @RequestMapping(value = "/delete/{guestId}")
    ResponseEntity<String> deleteGuest(
            @ApiParam(value = "request for adding a new Guest") @PathVariable final Long guestId);

}
