import React from 'react'
import NavDropdown from 'react-bootstrap/NavDropdown';

function MenuEnfermeiras() {

  return (
    <>
        <NavDropdown title="Pacientes" menuVariant="dark">
            <NavDropdown.Item as="button">
                Novo paciente
            </NavDropdown.Item>
            <NavDropdown.Divider/>
            <NavDropdown.Item as="button">
                Lista de pacientes
            </NavDropdown.Item>
        </NavDropdown>
        <NavDropdown title="Funcionários(as)" menuVariant="dark">
            <NavDropdown.Item as="button">
                Novo(a) funcionário(a)
            </NavDropdown.Item>
            <NavDropdown.Divider/>
            <NavDropdown.Item as="button">
                Lista de funcionários(as)
            </NavDropdown.Item>
        </NavDropdown>
        <NavDropdown title="Enfermeiras(os)" menuVariant="dark">
            <NavDropdown.Item as="button">
                Nova(o) enfermeira(o)
            </NavDropdown.Item>
            <NavDropdown.Divider/>
            <NavDropdown.Item as="button">
                Lista de enfermeiras(os)
            </NavDropdown.Item>
        </NavDropdown>
        <NavDropdown title="Médicos(as)" menuVariant="dark">
            <NavDropdown.Item as="button">
                Novo(a) médico(a)
            </NavDropdown.Item>
            <NavDropdown.Divider/>
            <NavDropdown.Item as="button">
                Lista de médicos(as)
            </NavDropdown.Item>
        </NavDropdown>
        <NavDropdown title="Visitas" menuVariant="dark">
            <NavDropdown.Item as="button">
                Nova visita
            </NavDropdown.Item>
            <NavDropdown.Divider/>
            <NavDropdown.Item as="button">
                Lista de visitas
            </NavDropdown.Item>
        </NavDropdown>
        <NavDropdown title="Fornecedores" menuVariant="dark">
            <NavDropdown.Item as="button">
                Novo fornecedor
            </NavDropdown.Item>
            <NavDropdown.Divider/>
            <NavDropdown.Item as="button">
                Lista de fornecedores
            </NavDropdown.Item>
        </NavDropdown>
        <NavDropdown title="Anamneses" menuVariant="dark">
            <NavDropdown.Item as="button">
                Nova anamnese
            </NavDropdown.Item>
            <NavDropdown.Divider/>
            <NavDropdown.Item as="button">
                Lista de anamneses
            </NavDropdown.Item>
        </NavDropdown>
        <NavDropdown title="Agendamentos" menuVariant="dark">
            <NavDropdown.Item as="button">
                Agendar visita
            </NavDropdown.Item>
            <NavDropdown.Item as="button">
                Agenda de visitas
            </NavDropdown.Item>
            <NavDropdown.Divider/>
            <NavDropdown.Item as="button">
                Agendar consulta
            </NavDropdown.Item>
            <NavDropdown.Item as="button">
                Agenda de consultas
            </NavDropdown.Item>
            <NavDropdown.Divider/>
            <NavDropdown.Item as="button">
                Agendar cirurgia
            </NavDropdown.Item>
            <NavDropdown.Item as="button">
                Agenda de cirurgias
            </NavDropdown.Item>
        </NavDropdown>
    </>
  )
}

export default MenuEnfermeiras