import React from 'react'
import Card from 'react-bootstrap/Card'
import Row from 'react-bootstrap/Row'
import Col from 'react-bootstrap/Col'
import Form from 'react-bootstrap/Form'
import Container from 'react-bootstrap/Container'
import Button from 'react-bootstrap/Button'
import NavigationBar from '../components/NavigationBar'
import * as yup from 'yup'
import { Formik } from 'formik'
import Uf from '../helpers/Uf'


type PacienteProps = {
    id: number,
    nome: string,
    sobrenome: string,
    cpf: string,
    dataNascimento: Date,
    contato: string,
    estadoCivil: string,
    sexo: string,
    endereco: EnderecoProps,
    anamnese: AnamneseProps,
}

type EnderecoProps = {
    rua: string,
    bairro: string,
    numero: string,
    cidade: string,
    cep: string,
    uf: string
}

type AnamneseProps = {
    id: number,
    altura: number,
    peso: number,
    ocupacao: string,
    fumante: boolean,
    disturbioCirculatorio: boolean,
    epilepsia: boolean,
    intestinoRegular: boolean,
    diabetes: boolean,
    tipoDiabetes?: string,
    tratamentoMedico: boolean,
    tipoTratMedico?: string,
    cirurgiaRecente: boolean,
    tipoCirurgia?: string,
    problemaPele: boolean,
    tipoProbPele?: string,
    proteseCorporalFacial: boolean,
    tipoProtese?: string,
    algumOutroProblema: boolean,
    tipoOutroProblema?: string,
    alteracoesCardiacas: boolean,
    disturbioHormonal: boolean,
    hipoHipertensalArterial: boolean,
    disturbioRenal: boolean,
    varizesLesoes: boolean,
    tipoLesao?: string,
    gestante?: boolean,
    alergia: boolean,
    tipoAlergia?: string,
    tumorLesaoPreCancerosa: boolean,
    tipoTumorLesaoPreCancerosa?: string,
    probsOrtopedicos: boolean,
    tipoProbsOrtopedicos?: string,
    utilizaAcidos: boolean,
    tipoAcido?: string,
}

const schema = yup.object().shape({
    nome: yup.string().required(),
    sobrenome: yup.string().required(),
    cpf: yup.string().min(14).max(14).required(),
    dataNascimento: yup.date().required(),
    contato: yup.string().min(18).max(18).required(),
    estadoCivil: yup.string().required(),
    sexo: yup.string().required(),
    endereco: yup.object().shape({
        rua: yup.string().required(),
        bairro: yup.string().required(),
        numero: yup.string().required(),
        cidade: yup.string().required(),
        cep: yup.string().min(10).max(10).required(),
        uf: yup.string().min(2).max(2).required()
    }).required(),
    anamnese: yup.object().shape({
        altura: yup.number().required(),
        peso: yup.number().required(),
        ocupacao: yup.string().required(),
        fumante: yup.boolean().required(),
        disturbioCirculatorio: yup.boolean().required(),
        epilepsia: yup.boolean().required(),
        intestinoRegular: yup.boolean().required(),
        diabetes: yup.boolean().required(),
        tratamentoMedico: yup.boolean().required(),
        cirurgiaRecente: yup.boolean().required(),
        problemaPele: yup.boolean().required(),
        proteseCorporalFacial: yup.boolean().required(),
        algumOutroProblema: yup.boolean().required(),
        alteracoesCardiacas: yup.boolean().required(),
        disturbioHormonal: yup.boolean().required(),
        hipoHipertensalArterial: yup.boolean().required(),
        disturbioRenal: yup.boolean().required(),
        varizesLesoes: yup.boolean().required(),
        alergia: yup.boolean().required(),
        tumorLesaoPreCancerosa: yup.boolean().required(),
        probsOrtopedicos: yup.boolean().required(),
        utilizaAcidos: yup.boolean().required(),
    }).required()
});

const ufs: string[] = Uf;

function pacienteadd() {
  return (
    <>
    <NavigationBar/>
    <Formik
        validationSchema={schema}
        onSubmit={console.log}
        initialValues={{
            nome: '',
            sobrenome: '',
            cpf: '',
            dataNascimento: '',
            contato: 0,
            estadoCivil: '',
            sexo: '',
            endereco: {
                rua: '',
                bairro: '',
                numero: 0,
                cidade: '',
                estado: '',
                uf: ''
            },
            anamnese: {
                altura: 0,
                peso: 0,
                ocupacao: '',
                fumante: false,
                disturbioCirculatorio: false,
                epilepsia: false,
                instestinoRegular: false,
                diabetes: false,
                tipoDiabetes: '',
                tratamentoMedico: false,
                tipoTratMedico: '',
                cirurgiaRecentes: false,
                tipoCirurgia: '',
                problemaPele: false,
                tipoProbPele: '',
                proteseCorporalFacial: false,
                tipoProtese: '',
                algumOutroProblema: false,
                tipoOutroProblema: '',
                alteracoesCardiacas: false,
                disturbioHormonal: false,
                hipoHipertensaoArterial: false,
                disturbioRenal: false,
                varizesLesoes: false,
                tipoLesao: '',
                tumorLesaoPreCancerosa: false,
                tipoTumorLesaoPreCancerosa: '',
                probsOrtopedicos: false,
                tipoProbsOrtopedicos: '',
                utilizaAcidos: false,
                tipoAcido: ''
            }
        }}>
            {({
                handleSubmit,
                handleChange,
                handleBlur,
                values,
                errors,
                touched,
                isValid,
            }) => (
                <Container className="mt-2">
                    <Card className="shadow-lg">
                        <Card.Header>Cadastro de Paciente</Card.Header>
                        <Card.Body>
                            <Card.Title>Dados pessoais</Card.Title>
                                <Form noValidate onSubmit={handleSubmit}>  
                                    <Row>
                                        <Col xl={4} lg={4}>
                                            <Form.Group controlId='validationPacNome'>
                                                <Form.Label>Nome</Form.Label>
                                                <Form.Control
                                                type="text"
                                                name="nome"
                                                value={values.nome}
                                                onChange={handleChange}
                                                isValid={touched.nome && !errors.nome}/>
                                            </Form.Group>
                                        </Col>
                                        <Col xl={4} lg={4}>
                                            <Form.Group controlId='validationPacSobrenome'>
                                                <Form.Label>Sobrenome</Form.Label>
                                                <Form.Control
                                                    type="text"
                                                    name="sobrenome"
                                                    value={values.sobrenome}
                                                    onChange={handleChange}
                                                    isValid={touched.sobrenome && !errors.sobrenome}/>
                                            </Form.Group>
                                        </Col>
                                        <Col xl={4} lg={4}>
                                            <Form.Group controlId='validationPacCpf'>
                                                <Form.Label>CPF</Form.Label>
                                                <Form.Control
                                                    type="text"
                                                    name="cpf"
                                                    value={values.cpf}
                                                    onChange={handleChange}
                                                    isValid={touched.cpf && !errors.cpf}/>
                                            </Form.Group>
                                        </Col>
                                        <Col xl={4} lg={4}>
                                            <Form.Group controlId='validationPacDataNasc'>
                                                <Form.Label>Data de nascimento</Form.Label>
                                                <Form.Control
                                                    type="date"
                                                    name="dataNascimento"
                                                    value={values.dataNascimento}
                                                    onChange={handleChange}
                                                    isValid={touched.dataNascimento && !errors.dataNascimento}/>
                                            </Form.Group>
                                        </Col>
                                        <Col xl={4} lg={4}>
                                            <Form.Group controlId='validationPacContato'>
                                                <Form.Label>Contato</Form.Label>
                                                <Form.Control
                                                    type="text"
                                                    name="contato"
                                                    value={values.contato}
                                                    onChange={handleChange}
                                                    isValid={touched.contato && !errors.contato}/>
                                            </Form.Group>
                                        </Col>
                                        <Col xl={2} lg={2}>
                                            <Form.Group controlId='validationPacEstadoCivil'>
                                                <Form.Label>Estado Civil</Form.Label>
                                                <Form.Select defaultValue="Selecione uma opção" onChange={handleChange}>
                                                    <option>Selecionar</option>
                                                    <option value="Solteiro">Solteiro(a)</option>
                                                    <option value="Casado">Casado(a)</option>
                                                </Form.Select>
                                            </Form.Group>
                                        </Col>
                                        <Col xl={2} lg={2}>
                                            <Form.Group controlId='validationPacSexo'>
                                                <Form.Label>Sexo</Form.Label>
                                                <Form.Select defaultValue="Selecione uma opção" onChange={handleChange}>
                                                    <option>Selecionar</option>
                                                    <option value="Masculino">Masculino</option>
                                                    <option value="Feminino">Feminino</option>
                                                    <option value="Outro">Outro</option>
                                                </Form.Select>
                                            </Form.Group>
                                        </Col>
                                        <Col xl={12} lg={12}>
                                            <hr />
                                        </Col>
                                        <Card.Title>Endereço</Card.Title>
                                        <Col xl={4} lg={4}>
                                            <Form.Group controlId='validationPacRua'>
                                                <Form.Label>Rua</Form.Label>
                                                <Form.Control
                                                    type="text"
                                                    name="rua"
                                                    value={values.endereco.rua}
                                                    onChange={handleChange}
                                                    isValid={touched.endereco?.rua && !errors.endereco?.rua}/>
                                            </Form.Group>
                                        </Col>
                                        <Col xl={4} lg={4}>
                                            <Form.Group controlId='validationPacBairro'>
                                                <Form.Label>Bairro</Form.Label>
                                                <Form.Control
                                                    type="text"
                                                    name="bairro"
                                                    value={values.endereco.bairro}
                                                    onChange={handleChange}
                                                    isValid={touched.endereco?.bairro && !errors.endereco?.bairro}/>
                                            </Form.Group>
                                        </Col>
                                        <Col xl={2} lg={2}>
                                            <Form.Group controlId='validationPacNumero'>
                                                <Form.Label>Número</Form.Label>
                                                <Form.Control
                                                    type="text"
                                                    name="numero"
                                                    value={values.endereco.numero}
                                                    onChange={handleChange}
                                                    isValid={touched.endereco?.numero && !errors.endereco?.numero}/>
                                            </Form.Group>
                                        </Col>
                                        <Col xl={2} lg={2}>
                                            <Form.Group controlId='validationPacUf'>
                                                <Form.Label>UF</Form.Label>
                                                <Form.Select onChange={handleChange}>
                                                    {ufs.map((uf, index) => (
                                                            <option key={index} value={uf}>{uf}</option>
                                                    ))}
                                                </Form.Select>
                                            </Form.Group>
                                        </Col>
                                        <Col xl={6} lg={6}>
                                            <Form.Group controlId='validationPacCidade'>
                                                <Form.Label>Cidade</Form.Label>
                                                <Form.Control
                                                    type="text"
                                                    name="cidade"
                                                    value={values.endereco.cidade}
                                                    onChange={handleChange}
                                                    isValid={touched.endereco?.cidade && !errors.endereco?.cidade}/>
                                            </Form.Group>
                                        </Col>
                                        <Col xl={6} lg={6}>
                                            <Form.Group controlId='validationPacEstado'>
                                                <Form.Label>Estado</Form.Label>
                                                <Form.Control
                                                    type="text"
                                                    name="estado"
                                                    value={values.endereco.estado}
                                                    onChange={handleChange}
                                                    isValid={touched.endereco?.estado && !errors.endereco?.estado}/>
                                            </Form.Group>
                                        </Col>
                                        <Col xl={12} lg={12}>
                                            <hr />
                                        </Col>
                                        <Card.Title>Dados da Anamnese</Card.Title>
                                        <Col xl={2} lg={2}>
                                            <Form.Group controlId='validationPacAnamneseAltura'>
                                                <Form.Label>Altura</Form.Label>
                                                <Form.Control
                                                    type="number"
                                                    name="altura"
                                                    value={values.anamnese.altura}
                                                    onChange={handleChange}
                                                    isValid={touched.anamnese?.altura && !errors.anamnese?.altura}/>
                                            </Form.Group>
                                        </Col>
                                        <Col xl={2} lg={2}>
                                            <Form.Group controlId='validationPacAnamnesePeso'>
                                                <Form.Label>Peso</Form.Label>
                                                <Form.Control
                                                    type="number"
                                                    name="peso"
                                                    value={values.anamnese.peso}
                                                    onChange={handleChange}
                                                    isValid={touched.anamnese?.peso && !errors.anamnese?.peso}/>
                                            </Form.Group>
                                        </Col>
                                        <Col xl={8} lg={8}>
                                            <Form.Group controlId='validationPacAnamneseOcupacao'>
                                                <Form.Label>Ocupação</Form.Label>
                                                <Form.Control
                                                    type="text"
                                                    name="ocupacao"
                                                    value={values.anamnese.ocupacao}
                                                    onChange={handleChange}
                                                    isValid={touched.anamnese?.ocupacao && !errors.anamnese?.ocupacao}/>
                                            </Form.Group>
                                        </Col>
                                        <Col xl={12} lg={12}>
                                            <hr />
                                        </Col>
                                        <Col xl={3} lg={3} className="mt-2">
                                            <Form.Group controlId='validationPacAnamneseFumante'>
                                                <Form.Label>É fumante?</Form.Label>
                                                <div>
                                                    <Form.Check
                                                    inline
                                                    label="Sim"
                                                    type="radio"
                                                    name="fumante"
                                                    value="Sim"
                                                    />
                                                    <Form.Check
                                                    inline
                                                    label="Não"
                                                    type="radio"
                                                    name="fumante"
                                                    value="Nao"
                                                    />
                                                </div>
                                            </Form.Group>
                                        </Col>
                                        <Col xl={3} lg={3} className="mt-2">
                                            <Form.Group controlId='validationPacAnamneseDistCirculatorio'>
                                                <Form.Label>Possui problema circulatório?</Form.Label>
                                                <div>
                                                    <Form.Check
                                                    inline
                                                    label="Sim"
                                                    type="radio"
                                                    name="distCirculatorio"
                                                    value="Sim"
                                                    />
                                                    <Form.Check
                                                    inline
                                                    label="Não"
                                                    type="radio"
                                                    name="distCirculatorio"
                                                    value="Nao"
                                                    />
                                                </div>
                                            </Form.Group>
                                        </Col>
                                        <Col xl={3} lg={3} className="mt-2">
                                            <Form.Group controlId='validationPacAnamneseEpilepsia'>
                                                <Form.Label>Possui Epilepsia?</Form.Label>
                                                <div>
                                                    <Form.Check
                                                    inline
                                                    label="Sim"
                                                    type="radio"
                                                    name="epilepsia"
                                                    value="Sim"
                                                    />
                                                    <Form.Check
                                                    inline
                                                    label="Não"
                                                    type="radio"
                                                    name="epilepsia"
                                                    value="Nao"
                                                    />
                                                </div>
                                            </Form.Group>
                                        </Col>
                                        <Col xl={3} lg={3} className="mt-2">
                                            <Form.Group controlId='validationPacAnamneseInstRegular'>
                                                <Form.Label>Possui intestino regular?</Form.Label>
                                                <div>
                                                    <Form.Check
                                                    inline
                                                    label="Sim"
                                                    type="radio"
                                                    name="instRegular"
                                                    value="Sim"
                                                    />
                                                    <Form.Check
                                                    inline
                                                    label="Não"
                                                    type="radio"
                                                    name="instRegular"
                                                    value="Nao"
                                                    />
                                                </div>
                                            </Form.Group>
                                        </Col>
                                        <Col xl={3} lg={3} className="mt-2">
                                            <Form.Group controlId='validationPacAnamneseDiabetes'>
                                                <Form.Label>Possui diabetes?</Form.Label>
                                                <div>
                                                    <Form.Check
                                                    inline
                                                    label="Sim"
                                                    type="radio"
                                                    name="diabetes"
                                                    value="Sim"
                                                    />
                                                    <Form.Check
                                                    inline
                                                    label="Não"
                                                    type="radio"
                                                    name="diabetes"
                                                    value="Nao"
                                                    />
                                                </div>
                                            </Form.Group>
                                        </Col>
                                        <Col xl={3} lg={3} className="mt-2">
                                            <Form.Group controlId='validationPacAnamneseTratMedico'>
                                                <Form.Label>Faz tratamento médico?</Form.Label>
                                                <div>
                                                    <Form.Check
                                                    inline
                                                    label="Sim"
                                                    type="radio"
                                                    name="tratMedico"
                                                    value="Sim"
                                                    />
                                                    <Form.Check
                                                    inline
                                                    label="Não"
                                                    type="radio"
                                                    name="tratMedico"
                                                    value="Nao"
                                                    />
                                                </div>
                                            </Form.Group>
                                        </Col>
                                        <Col xl={3} lg={3} className="mt-2">
                                            <Form.Group controlId='validationPacAnamneseCirRecente'>
                                                <Form.Label>Possui cirurgia recente?</Form.Label>
                                                <div>
                                                    <Form.Check
                                                    inline
                                                    label="Sim"
                                                    type="radio"
                                                    name="cirRecente"
                                                    value="Sim"
                                                    />
                                                    <Form.Check
                                                    inline
                                                    label="Não"
                                                    type="radio"
                                                    name="cirRecente"
                                                    value="Nao"
                                                    />
                                                </div>
                                            </Form.Group>
                                        </Col>
                                        <Col xl={3} lg={3} className="mt-2">
                                            <Form.Group controlId='validationPacAnamneseProbPele'>
                                                <Form.Label>Possui problema de pele?</Form.Label>
                                                <div>
                                                    <Form.Check
                                                    inline
                                                    label="Sim"
                                                    type="radio"
                                                    name="probPele"
                                                    value="Sim"
                                                    />
                                                    <Form.Check
                                                    inline
                                                    label="Não"
                                                    type="radio"
                                                    name="probPele"
                                                    value="Nao"
                                                    />
                                                </div>
                                            </Form.Group>
                                        </Col>
                                        <Col xl={3} lg={3} className="mt-2">
                                            <Form.Group controlId='validationPacAnamneseProtese'>
                                                <Form.Label>Possui prótese?</Form.Label>
                                                <div>
                                                    <Form.Check
                                                    inline
                                                    label="Sim"
                                                    type="radio"
                                                    name="protese"
                                                    value="Sim"
                                                    />
                                                    <Form.Check
                                                    inline
                                                    label="Não"
                                                    type="radio"
                                                    name="protese"
                                                    value="Nao"
                                                    />
                                                </div>
                                            </Form.Group>
                                        </Col>
                                        <Col xl={3} lg={3} className="mt-2">
                                            <Form.Group controlId='validationPacAnamneseAlgumOutroProb'>
                                                <Form.Label>Possui outro problema?</Form.Label>
                                                <div>
                                                    <Form.Check
                                                    inline
                                                    label="Sim"
                                                    type="radio"
                                                    name="algumOutroProb"
                                                    value="Sim"
                                                    />
                                                    <Form.Check
                                                    inline
                                                    label="Não"
                                                    type="radio"
                                                    name="algumOutroProb"
                                                    value="Nao"
                                                    />
                                                </div>
                                            </Form.Group>
                                        </Col>
                                        <Col xl={3} lg={3} className="mt-2">
                                            <Form.Group controlId='validationPacAnamneseAltCardiaca'>
                                                <Form.Label>Possui alterações cardíacas?</Form.Label>
                                                <div>
                                                    <Form.Check
                                                    inline
                                                    label="Sim"
                                                    type="radio"
                                                    name="altCardiaca"
                                                    value="Sim"
                                                    />
                                                    <Form.Check
                                                    inline
                                                    label="Não"
                                                    type="radio"
                                                    name="altCardiaca"
                                                    value="Nao"
                                                    />
                                                </div>
                                            </Form.Group>
                                        </Col>
                                        <Col xl={3} lg={3} className="mt-2">
                                            <Form.Group controlId='validationPacAnamneseDistHormonal'>
                                                <Form.Label>Possui distúrbio hormonal?</Form.Label>
                                                <div>
                                                    <Form.Check
                                                    inline
                                                    label="Sim"
                                                    type="radio"
                                                    name="distHormonal"
                                                    value="Sim"
                                                    />
                                                    <Form.Check
                                                    inline
                                                    label="Não"
                                                    type="radio"
                                                    name="distHormonal"
                                                    value="Nao"
                                                    />
                                                </div>
                                            </Form.Group>
                                        </Col>
                                        <Col xl={3} lg={3} className="mt-2">
                                            <Form.Group controlId='validationPacAnamneseHipoHipertensaoArterial'>
                                                <Form.Label>Possui hipertensão arterial?</Form.Label>
                                                <div>
                                                    <Form.Check
                                                    inline
                                                    label="Sim"
                                                    type="radio"
                                                    name="hipoHipertensaoArterial"
                                                    value="Sim"
                                                    />
                                                    <Form.Check
                                                    inline
                                                    label="Não"
                                                    type="radio"
                                                    name="hipoHipertensaoArterial"
                                                    value="Nao"
                                                    />
                                                </div>
                                            </Form.Group>
                                        </Col>
                                        <Col xl={3} lg={3} className="mt-2">
                                            <Form.Group controlId='validationPacAnamneseDistRenal'>
                                                <Form.Label>Possui distúrbio renal?</Form.Label>
                                                <div>
                                                    <Form.Check
                                                    inline
                                                    label="Sim"
                                                    type="radio"
                                                    name="distRenal"
                                                    value="Sim"
                                                    />
                                                    <Form.Check
                                                    inline
                                                    label="Não"
                                                    type="radio"
                                                    name="distRenal"
                                                    value="Nao"
                                                    />
                                                </div>
                                            </Form.Group>
                                        </Col>
                                        
                                        <Col xl={3} lg={3} className="mt-2">
                                            <Form.Group controlId='validationPacAnamneseVarizesLesoes'>
                                                <Form.Label>Possui varizes ou lesões?</Form.Label>
                                                <div>
                                                    <Form.Check
                                                    inline
                                                    label="Sim"
                                                    type="radio"
                                                    name="varizesLesoes"
                                                    value="Sim"
                                                    />
                                                    <Form.Check
                                                    inline
                                                    label="Não"
                                                    type="radio"
                                                    name="varizesLesoes"
                                                    value="Nao"
                                                    />
                                                </div>
                                            </Form.Group>
                                        </Col>
                                        
                                        <Col xl={3} lg={3} className="mt-2">
                                            <Form.Group controlId='validationPacAnamneseGestante'>
                                                <Form.Label>É gestante?</Form.Label>
                                                <div>
                                                    <Form.Check
                                                    inline
                                                    label="Sim"
                                                    type="radio"
                                                    name="gestante"
                                                    value="Sim"
                                                    />
                                                    <Form.Check
                                                    inline
                                                    label="Não"
                                                    type="radio"
                                                    name="gestante"
                                                    value="Nao"
                                                    />
                                                </div>
                                            </Form.Group>
                                        </Col>
                                        
                                        <Col xl={3} lg={3} className="mt-2">
                                            <Form.Group controlId='validationPacAnamneseAlergia'>
                                                <Form.Label>Possui alergia?</Form.Label>
                                                <div>
                                                    <Form.Check
                                                    inline
                                                    label="Sim"
                                                    type="radio"
                                                    name="alergia"
                                                    value="Sim"
                                                    />
                                                    <Form.Check
                                                    inline
                                                    label="Não"
                                                    type="radio"
                                                    name="alergia"
                                                    value="Nao"
                                                    />
                                                </div>
                                            </Form.Group>
                                        </Col>
                                        <Col xl={3} lg={3} className="mt-2">
                                            <Form.Group controlId='validationPacAnamneseTumorLesaoPreCancerosa'>
                                                <Form.Label>Possui tumor/lesão cancerosa?</Form.Label>
                                                <div>
                                                    <Form.Check
                                                    inline
                                                    label="Sim"
                                                    type="radio"
                                                    name="tumorLesaoPreCancerosa"
                                                    value="Sim"
                                                    />
                                                    <Form.Check
                                                    inline
                                                    label="Não"
                                                    type="radio"
                                                    name="tumorLesaoPreCancerosa"
                                                    value="Nao"
                                                    />
                                                </div>
                                            </Form.Group>
                                        </Col>
                                        <Col xl={3} lg={3} className="mt-2">
                                            <Form.Group controlId='validationPacAnamneseprobsOrtopedicos'>
                                                <Form.Label>Possui problemas ortopédicos?</Form.Label>
                                                <div>
                                                    <Form.Check
                                                    inline
                                                    label="Sim"
                                                    type="radio"
                                                    name="probsOrtopedicos"
                                                    value="Sim"
                                                    />
                                                    <Form.Check
                                                    inline
                                                    label="Não"
                                                    type="radio"
                                                    name="probsOrtopedicos"
                                                    value="Nao"
                                                    />
                                                </div>
                                            </Form.Group>
                                        </Col>
                                        <Col xl={3} lg={3} className="mt-2">
                                            <Form.Group controlId='validationPacAnamneseAcido'>
                                                <Form.Label>Utiliza ácidos?</Form.Label>
                                                <div>
                                                    <Form.Check
                                                    inline
                                                    label="Sim"
                                                    type="radio"
                                                    name="acido"
                                                    value="Sim"
                                                    />
                                                    <Form.Check
                                                    inline
                                                    label="Não"
                                                    type="radio"
                                                    name="acido"
                                                    value="Nao"
                                                    />
                                                </div>
                                            </Form.Group>
                                        </Col>
                                        <Col xl={12} lg={12}>
                                            <hr />
                                        </Col>
                                        <div className="d-grid gap-2">
                                            <Button variant="success">
                                                Salvar
                                            </Button>
                                        </div>
                                    </Row>
                                </Form>
                        </Card.Body>
                    </Card>
                </Container>
            )}
    </Formik>
    </>
  )
}

export default pacienteadd