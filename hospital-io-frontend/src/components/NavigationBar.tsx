import React from 'react';
import Container from 'react-bootstrap/Container';
import Navbar from 'react-bootstrap/Navbar';
import Nav from 'react-bootstrap/Nav';
import NavigationBarLeft from './NavigationBarLeft';
import NavigationBarRight from './NavigationBarRight';

function NavigationBar() {

  return (
    <Navbar collapseOnSelect expand="xl" sticky="top" bg="dark" variant="dark">
      <Container>
        <Navbar.Brand>Hospital IO</Navbar.Brand>
        <Navbar.Toggle aria-controls="basic-navbar-nav" />
        <Navbar.Collapse id="basic-navbar-nav">
          <Nav className="me-auto">
            <NavigationBarLeft/>
          </Nav>
          <Nav>
            <NavigationBarRight/>
          </Nav>
        </Navbar.Collapse>
      </Container>
    </Navbar>
  )
}

export default NavigationBar