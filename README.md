# gestion-turnos
Sistema de Gestión de Turnos Médicos (app de escritorio) en Java

- El sistema en principio será utilizado exclusivamente por una recepcionista en el lugar. 

- Aclaraciones sobre Turnos:

Se otorgan de Lunes a Viernes de 9 a 18 hs.
Duración fija: 30 minutos. (18 turnos por día)

1. Se usa enum para los estados de los turnos: PENDIENTE, CONFIRMADO, ATENDIDO, AUSENTE, CANCELADO
2. Se agregan validaciones básicas (not null) y para evitar solapamientos de turnos por mismo doctor, paciente y/o misma fecha y hora.


- Aclaraciones sobre Usuarios

1. Usuario es una clase abstracta qu tiene por default nombre, password y correo, atributos comunes para todos los usuarios. Esta clase abstracta también permite tener tipos de usuarios como Doctor, Paciente y más adelante Administrador, Recepcionista o el que sea necesario.

2. Doctor ademas de los atributos y metodos heredados de Usuario tiene especialidad. En el caso de Paciente, se suman atributos como dni y telefono.

3. Se agregan Controladores para el manejo de Doctores, Pacientes, especialidades y turnos.

4. Los Ids de Doctores, Pacientes, Especialidades y turnos son autoincrementales.

