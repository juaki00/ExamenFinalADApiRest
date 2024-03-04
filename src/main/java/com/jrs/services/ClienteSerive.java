package com.jrs.services;

import com.jrs.extra.AutenticacionException;
import com.jrs.models.Cliente;
import com.jrs.repositories.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class InformacionClienteSerive {

    @Autowired
    ClienteRepository clienteRepository;

    @Autowired
    SecurityService securityService;

    public List<Cliente> getAll( String token ) {
        if(securityService.validateToken( token )) {
            return clienteRepository.findAll( );
        }
        else{
            throw new AutenticacionException( "No autorizado, token no valido" );
        }
    }


//    @Autowired
//    private OcupacionRepository ocupacionRepository;
//    @Autowired
//    private OcupacionRepositoryCompleto ocupacionRepositoryCompleto;
//    private final static Logger LOGGER = LoggerFactory.getLogger( OcupacionSerive.class );
//
//
//    /**
//     * The getAll function returns a list of all the OcupacionResponse objects in the database.
//     *
//     * @return A list of ocupaciondto
//     */
//    public List<OcupacionResponse> getAll( ) {
//        LOGGER.info( "Entra getAll" );
//        List<OcupacionCompletoDTO> lista = ocupacionRepositoryCompleto.findAll( );
//
//        List<OcupacionResponse> listaResult = new ArrayList<>(  );
//        listaResult = lista.stream( ).map( ocupacionCompletoDTO -> {
//            OcupacionResponse ocupacionResponse= new OcupacionResponse();
//            ocupacionResponse.setData( ocupacionCompletoDTO.getData().getFirst().getValor() );
//            ocupacionResponse.setId( ocupacionCompletoDTO.getId( ) );
//            ocupacionResponse.setNombre( ocupacionCompletoDTO.getNombre( ) );
//            return ocupacionResponse;
//        } ).collect( Collectors.toList() );
//        return listaResult;
//    }
//
//
//    /**
//     * The getOcupacionPorTipo function is used to get a list of occupations from the database that match the given type.
//     *
//     * @param tipo Filter the list of ocupacioncompletodto objects
//     * @return A list of ocupacioncompletodto objects
//     */
//    public List<OcupacionCompletoDTO> getOcupacionPorTipo( String tipo ) {
//
//        LOGGER.info( "Empieza getOcupacionPorTipo - tipo: " + tipo );
//        List<OcupacionCompletoDTO> resultado = new ArrayList<>( );
//        List<OcupacionCompletoDTO> todos = this.ocupacionRepositoryCompleto.findAll( );
//        resultado = todos.stream( ).filter( objeto -> objeto.getMetaData( ).get( 1 ).getNombre( )
//                        .equals( FormatearCodigoOcupacion.formatearCodigoTipo( tipo ) ) )
//                .collect( Collectors.toList( ) );
//        LOGGER.info( "Termina getOcupacionPorTipo - resultado: " + resultado );
//        return resultado;
//    }
//
//    /**
//     * The getOcupacionPorMes function is used to get the occupation by month.
//     *
//     * @param mes Filter the data in the repository
//     * @return A list of ocupacioncompletodto objects
//     */
//    public List<OcupacionCompletoDTO> getOcupacionPorMes( String mes ) {
//        LOGGER.info( "Empieza getOcupacionPorMes - mes: " + mes );
//        List<OcupacionCompletoDTO> resultado = new ArrayList<>( );
//        List<OcupacionCompletoDTO> todos = this.ocupacionRepositoryCompleto.findAll( );
//        resultado = todos.stream( ).filter( objeto -> objeto.getMetaData( ).get( 0 ).getCodigo( )
//                        .equals( mes ) )
//                .collect( Collectors.toList( ) );
//        LOGGER.info( "Termina getOcupacionPorMes - resultado: " + resultado );
//        return resultado;
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
//    public OcupacionCompletoDTO getOcupacionPorTipoYMes( String tipo , String mes ) {
//        LOGGER.info( "Empieza getOcupacionPorMes - mes: " + mes );
//        List<OcupacionCompletoDTO> resultado = new ArrayList<>( );
//        List<OcupacionCompletoDTO> todos = this.ocupacionRepositoryCompleto.findAll( );
//        resultado = todos.stream( ).filter( objeto -> objeto.getMetaData( ).get( 0 ).getCodigo( )
//                        .equals( mes ) )
//                .collect( Collectors.toList( ) );
//        resultado = resultado.stream( ).filter( objeto -> objeto.getMetaData( ).get( 1 ).getNombre( )
//                        .equals( FormatearCodigoOcupacion.formatearCodigoTipo( tipo ) ) )
//                .collect( Collectors.toList( ) );
//        LOGGER.info( "Termina getOcupacionPorMes - resultado: " + resultado );
//        return resultado.getFirst( );
//    }
//
//
//    /**
//     * The insertOcupacion function inserts a new document into the ocupacion collection.
//     *
//     * @param mes Set the month of the occupation
//     * @param tipo Format the metadata codigo and nombre
//     * @param valor Set the value of the data attribute in ocupacioncompletodto
//     * @return The following:
//     */
//    public void insertOcupacion( String mes , String tipo , String valor ) {
//        LOGGER.info( "Comienza insertOcupacion" );
//        String tipoFormateado = FormatearCodigoOcupacion.formatearCodigoTipo( tipo );
//        String mesTitleCase = mes.substring( 0 , 1 ).toUpperCase( ) + mes.substring( 1 );
//        //crear modelo
//        OcupacionCompletoDTO insertOcupacionResponse = new OcupacionCompletoDTO( );
//        //crear data
//        DataOcupacion data = new DataOcupacion( );
//        List<DataOcupacion> listData = new ArrayList<>( );
//        data.setValor( Integer.parseInt( valor ) );
//        listData.add( data );
//        //crear metadata
//        MetaDataOcupacion metaDataMes = new MetaDataOcupacion( );
//        MetaDataOcupacion metaDataTipo = new MetaDataOcupacion( );
//        List<MetaDataOcupacion> listMetaData = new ArrayList<>( );
//        metaDataMes.setCodigo( mes );
//        metaDataMes.setNombre( mesTitleCase );
//        metaDataTipo.setCodigo( FormatearCodigoOcupacion.formatearCodigoMetadata( tipoFormateado ) );
//        metaDataTipo.setNombre( tipoFormateado );
//        listMetaData.add( metaDataMes );
//        listMetaData.add( metaDataTipo );
//        //setear atributos
//        insertOcupacionResponse.setData( listData );
//        insertOcupacionResponse.setMetaData( listMetaData );
//        insertOcupacionResponse.setNombre( mesTitleCase + ", " + tipoFormateado );
//        this.ocupacionRepositoryCompleto.save( insertOcupacionResponse );
//        LOGGER.info( "Fin insertOcupacion" );
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
//    public void updateOcupacion( String mes , String tipo , String valor ) {
//        LOGGER.info( "Comienza updateOcupacion" );
//        String tipoFormateado = FormatearCodigoOcupacion.formatearCodigoTipo( tipo );
//        String mesTitleCase = mes.substring( 0 , 1 ).toUpperCase( ) + mes.substring( 1 );
//        //crear modelo
//        OcupacionCompletoDTO ocupacionCompletoDTO = this.getOcupacionPorTipoYMes( tipo , mes );
//        //crear data
//        DataOcupacion data = new DataOcupacion( );
//        List<DataOcupacion> listData = new ArrayList<>( );
//        data.setValor( Integer.parseInt( valor ) );
//        listData.add( data );
//        //crear metadata
//        //setear atributos
//        ocupacionCompletoDTO.setData( listData );
//        this.ocupacionRepositoryCompleto.save( ocupacionCompletoDTO );
//        LOGGER.info( "Fin updateOcupacion" );
//    }
}
