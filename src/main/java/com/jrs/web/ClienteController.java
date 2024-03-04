package com.jrs.web;

import com.jrs.models.InformacionCliente;
import com.jrs.services.InformacionClienteSerive;
import com.jrs.services.SecurityService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Pattern;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ocupacion")
public class InformacionClienteController {

    @Autowired
    private InformacionClienteSerive informacionClienteSerive;

    @Autowired
    SecurityService securityService;

    /**
     * The getAllOcupaciones function is used to get all the ocupaciones from the database.
     *
     *
     *
     * @return A list of ocupaciondto objects
     *
     */
    @Operation(description = "Obtener todos los tipos de todos los meses",
            summary = "Obtener todas las ocupaciones", responses = {
            @ApiResponse(description = "Datos obtenidos correctamente", responseCode = "200") ,
            @ApiResponse(description = "Error en el cliente", responseCode = "400") ,
            @ApiResponse(description = "Error en el servidor", responseCode = "500")
    })
    @GetMapping("getAllOcupaciones")
    public List<InformacionCliente> getAllOcupaciones(@RequestParam String token ) {

            return informacionClienteSerive.getAll( token );
    }




//    @Operation(description = "",
//            summary = "", responses = {
//            @ApiResponse(description = "", responseCode = "200")
//    })
//    @GetMapping("")
//    public List<OcupacionCompletoDTO> name(
//            @Parameter(in = ParameterIn.QUERY, description = "",
//                    example = "ocupacion")
//            @Valid @Pattern(
//                    regexp = "^$")
//            @RequestParam(name = "variable")
//            String variable ) {
//        return this.informacionClienteSerive.name( variable );
//    }

//
//    /**
//     * The getOcupacionPorMes function is used to get the occupation by month.
//     *
//     * @param mes Filter the data in the repository
//     * @return A list of ocupacioncompletodto objects
//     */
//    @Operation(description = "Obtener ocupaciones por mes",
//            summary = "Obtener todas las ocupaciones de un mes", responses = {
//            @ApiResponse(description = "Todo ok", responseCode = "200")
//    })
//    @GetMapping("getOcupacionPorMes")
//    public List<OcupacionCompletoDTO> getOcupacionPorMes(
//            @Parameter(in = ParameterIn.QUERY, description = "Mes correspondiente o todos para el total",
//                    example = "enero", required = true)
//            @Valid @Pattern(
//                    regexp = "^(enero|febrero|marzo|abril|mayo|junio|julio|agosto|septiembre|octubre|noviembre|diciembre|total)$",
//                    message = "Debe introducir un mes correcto o \"todos\" para el general")
//            @RequestParam(name = "mes")
//            String mes ) {
//        return this.ocupacionSerive.getOcupacionPorMes( mes );
//    }
//
//    /**
//     * The getOcupacionPorTipoYMes function takes in a String tipo and a String mes,
//     * then returns an OcupacionCompletoDTO object.
//     *
//     * @param tipo Filter the results by type of occupation
//     * @param mes Filter the data by month
//     * @return An ocupacioncompletodto object
//     */
//    @Operation(description = "Obtener ocupaciones por tipo ymes",
//            summary = "Obtener todas las ocupaciones de un mes y un tipo", responses = {
//            @ApiResponse(description = "Todo ok", responseCode = "200")
//    })
//    @GetMapping("getOcupacionPorTipoYMes")
//    public OcupacionCompletoDTO getOcupacionPorTipoYMes(
//            @Parameter(in = ParameterIn.QUERY, description = "Mes correspondiente o todos para el total",
//                    example = "enero", required = true)
//            @Valid @Pattern(
//                    regexp = "^(enero|febrero|marzo|abril|mayo|junio|julio|agosto|septiembre|octubre|noviembre|diciembre|total)$",
//                    message = "Debe introducir un mes correcto o \"todos\" para el general")
//            @RequestParam(name = "mes")
//            String mes ,
//            @Parameter(in = ParameterIn.QUERY, description = "Tipos: ocupacion, ocupacionFin, establecimientos, plazas, personal",
//                    example = "ocupacion")
//            @Valid @Pattern(
//                    regexp = "^(ocupacion|establecimientos|plazas|ocupacionFin|personal)$")
//            @RequestParam(name = "tipo")
//            String tipo ) {
//        return this.ocupacionSerive.getOcupacionPorTipoYMes( tipo , mes );
//    }
//
//    /**
//     * The insertOcupacion function inserts a new document into the ocupacion collection.
//     *
//     * @param mes Set the month of the occupation
//     * @param tipo Format the metadata codigo and nombre
//     * @param valor Set the value of the data attribute in ocupacioncompletodto
//     * @return The following:
//     */
//    @Operation(description = "Insertar un nuevo tipo de ocupacion. Introducir mes, tipo y cantidad",
//            summary = "Insertar un nuevo tipo de ocupacion", responses = {
//            @ApiResponse(description = "Todo ok", responseCode = "200")
//    })
//    @PostMapping("insertOcupacion")
//    @ResponseStatus(HttpStatus.CREATED)
//    public void insertOcupacion(
//            @Parameter(in = ParameterIn.QUERY, description = "Mes correspondiente o todos para el total",
//                    example = "enero", required = true)
//            @Valid @Pattern(
//                    regexp = "^(enero|febrero|marzo|abril|mayo|junio|julio|agosto|septiembre|octubre|noviembre|diciembre|total)$",
//                    message = "Debe introducir un mes correcto o \"todos\" para el general")
//            @RequestParam(name = "mes")
//            String mes ,
//            @Parameter(in = ParameterIn.QUERY, description = "Tipos: ocupacion, ocupacionFin, establecimientos, plazas, personal",
//                    example = "ocupacion")
//            @Valid @Pattern(
//                    regexp = "^(ocupacion|establecimientos|plazas|ocupacionFin|personal)$")
//            @RequestParam(name = "tipo")
//            String tipo ,
//            @Parameter(in = ParameterIn.QUERY, description = "Valor",
//                    example = "100", required = true)
//            @Valid @Pattern(
//                    regexp = "^[0-9]{1,6}$",
//                    message = "Una cantidad de como maximo 6 cifras")
//            @RequestParam(name = "valor")
//            String valor ) {
//        this.ocupacionSerive.insertOcupacion( mes , tipo , valor );
//    }
//
//    /**
//     * The updateOcupacion function updates the value of a given ocupacion.
//     *
//     * @param mes Get the first letter of the month and capitalize it
//     * @param tipo Create a new dataocupacion object and set the value of its valor attribute
//     * @param valor Set the value of the dataocupacion object
//     * @return An object of type ocupacioncompletodto
//     */
//    @Operation(description = "Actualizar un tipo de ocupacion. Introducir mes, tipo y cantidad",
//            summary = "Actualizar un tipo de ocupacion", responses = {
//            @ApiResponse(description = "Todo ok", responseCode = "200")
//    })
//    @PutMapping("UpdateOcupacion")
//    @ResponseStatus(HttpStatus.CREATED)
//    public void updateOcupacion(
//            @Parameter(in = ParameterIn.QUERY, description = "Mes correspondiente o todos para el total",
//                    example = "enero", required = true)
//            @Valid @Pattern(
//                    regexp = "^(enero|febrero|marzo|abril|mayo|junio|julio|agosto|septiembre|octubre|noviembre|diciembre|total)$",
//                    message = "Debe introducir un mes correcto o \"todos\" para el general")
//            @RequestParam(name = "mes")
//            String mes ,
//            @Parameter(in = ParameterIn.QUERY, description = "Tipos: ocupacion, ocupacionFin, establecimientos, plazas, personal",
//                    example = "ocupacion")
//            @Valid @Pattern(
//                    regexp = "^(ocupacion|establecimientos|plazas|ocupacionFin|personal)$")
//            @RequestParam(name = "tipo")
//            String tipo ,
//            @Parameter(in = ParameterIn.QUERY, description = "Valor",
//                    example = "100", required = true)
//            @Valid @Pattern(
//                    regexp = "^[0-9]{1,6}$",
//                    message = "Una cantidad de como maximo 6 cifras")
//            @RequestParam(name = "valor")
//            String valor ) {
//        this.ocupacionSerive.updateOcupacion( mes , tipo , valor );
//    }

}
