# tcc_backend
REST API consisting of simple endpoints for manipulating employees´ last location´s database table, so that this information is available and accessible at the front-end.
- Language: Java
- Framework: Spring
- RDBMS: H2 Database

## Documentation:

HTTP Verb     | Endpoint                     | Function                                | Input [example]
------------- | -----------------------------|-----------------------------------------|-------------------------------------------------------------|
GET           | /ultimaslocalizacoes/        | Get all locations                       |                                                             |
POST          | /ultimaslocalizacoes/        | Insert a location                       | {matricula: ..., ultimaLongitude: ..., ultimaLatitude: ...} |
GET           | /ultimaslocalizacoes/{1}     | Get location by id                      | location's id                                               |
DELETE        | /ultimaslocalizacoes/{1}     | Delete location by id                   | location's id                                               |
PUT           | /preenchercomdadosiniciais/  | Location exists ? uptade it : insert it | {matricula: ..., ultimaLongitude: ..., ultimaLatitude: ...} |     
GET           | /preenchercomdadosiniciais/  | Inserts sample data                     |                                                             |
GET           | /limpartodos                 | Deletes all data                        |                                                             |
