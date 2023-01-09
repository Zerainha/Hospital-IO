import React, {useCallback} from 'react';
import Nav from 'react-bootstrap/Nav'
import MenuCaixa from './MenuCaixa';
import MenuEnfermeiras from './MenuEnfermeiras';
import MenuEstoquista from './MenuEstoquista';
import MenuMedicos from './MenuMedicos';
import MenuSecretarias from './MenuSecretarias';

function NavigationBarLeft() {

    let cargo: string = 'Enfermeira';

    const renderContent = useCallback(() => {
        switch (cargo) {
            case 'Enfermeira' :
                return <MenuEnfermeiras/>
            case 'Secretaria' :
                return <MenuSecretarias/>
            case 'Medico' :
                return <MenuMedicos/>
            case 'Caixa' :
                return <MenuCaixa/>
            case 'Estoquista' :
                return <MenuEstoquista/>
        }
    }, [cargo]);

    return (
        <Nav>
            {renderContent()}
        </Nav>
    )
}

export default NavigationBarLeft