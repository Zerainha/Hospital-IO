import React from 'react'
import NavDropdown from 'react-bootstrap/NavDropdown'

function MenuMedicos() {
  return (
    <div className='d-flex'>
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
    </div>
  )
}

export default MenuMedicos