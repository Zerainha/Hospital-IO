import React, {useCallback} from 'react'
import Container from 'react-bootstrap/Container'
import Row from 'react-bootstrap/Row'
import DashboardCaixa from './DashboardCaixa';
import DashboardEnfermeiras from './DashboardEnfermeiras';
import DashboardEstoquista from './DashboardEstoquista';
import DashboardMedico from './DashboardMedico';

function Dashboard() {

    let cargo: string = "Secretaria";

    const renderContent = useCallback(() => {
        switch (cargo) {
            case 'Secretaria':
                return <DashboardEnfermeiras/>
            case 'Enfermeira':
                return <DashboardEnfermeiras/>
            case 'Medico':
                return <DashboardMedico/>
            case 'Caixa':
                return <DashboardCaixa/>
            case 'Estoquista':
                return <DashboardEstoquista/>
        }
    }, [cargo]);

  return (
    <Container fluid className="mt-2">
        <Row>
            {renderContent()}
        </Row>
    </Container>
  )
}

export default Dashboard