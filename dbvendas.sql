-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Tempo de geração: 13-Out-2022 às 19:54
-- Versão do servidor: 10.4.25-MariaDB
-- versão do PHP: 8.0.23

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Banco de dados: `dbvendas`
--

-- --------------------------------------------------------

--
-- Estrutura da tabela `tblcliente`
--

CREATE TABLE `tblcliente` (
  `idcliente` int(11) NOT NULL,
  `cliente` varchar(100) NOT NULL,
  `email` varchar(100) NOT NULL,
  `celular` varchar(15) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Extraindo dados da tabela `tblcliente`
--

INSERT INTO `tblcliente` (`idcliente`, `cliente`, `email`, `celular`) VALUES
(1, 'Fellipe', 'fellipe1810@hotmail.com', '21999988888'),
(2, 'eu', 'eu', '123');

-- --------------------------------------------------------

--
-- Estrutura da tabela `tblestoque`
--

CREATE TABLE `tblestoque` (
  `idestoque` int(11) NOT NULL,
  `produto` varchar(50) NOT NULL,
  `idfornecedor` int(11) NOT NULL,
  `estoqueatu` int(11) NOT NULL,
  `estoquemax` int(11) NOT NULL,
  `estoquemin` int(11) NOT NULL,
  `preco` double(10,2) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Estrutura da tabela `tblfornecedor`
--

CREATE TABLE `tblfornecedor` (
  `idfornecedor` int(10) NOT NULL,
  `nomefornecedor` varchar(50) NOT NULL,
  `cnpj` int(14) NOT NULL,
  `empresa` varchar(50) NOT NULL,
  `celular` int(11) NOT NULL,
  `marca` varchar(50) NOT NULL,
  `produto` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Extraindo dados da tabela `tblfornecedor`
--

INSERT INTO `tblfornecedor` (`idfornecedor`, `nomefornecedor`, `cnpj`, `empresa`, `celular`, `marca`, `produto`) VALUES
(1, 'João', 1231231231, 'Adidas', 40002311, 'adidas', 'camisa'),
(2, 'eu', 12312312, 'nike brasil', 4212323, 'nike', 'blusa');

-- --------------------------------------------------------

--
-- Estrutura da tabela `tblperfil`
--

CREATE TABLE `tblperfil` (
  `idperfil` int(11) NOT NULL,
  `perfil` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Extraindo dados da tabela `tblperfil`
--

INSERT INTO `tblperfil` (`idperfil`, `perfil`) VALUES
(1, 'admin'),
(2, 'user'),
(3, 'gerente'),
(4, 'colaborador');

-- --------------------------------------------------------

--
-- Estrutura da tabela `tblproduto`
--

CREATE TABLE `tblproduto` (
  `idproduto` int(10) NOT NULL,
  `nome` varchar(50) NOT NULL,
  `valor` double(100,0) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Extraindo dados da tabela `tblproduto`
--

INSERT INTO `tblproduto` (`idproduto`, `nome`, `valor`) VALUES
(1, 'camisa adidas', 100),
(2, 'bermuda adidas', 80),
(3, 'casaco nike', 350),
(4, 'casaco adidas', 460);

-- --------------------------------------------------------

--
-- Estrutura da tabela `tblusuario`
--

CREATE TABLE `tblusuario` (
  `idusuario` int(11) NOT NULL,
  `usuario` varchar(50) NOT NULL,
  `fone` varchar(15) NOT NULL,
  `login` varchar(15) NOT NULL,
  `senha` varchar(15) NOT NULL,
  `perfil` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Extraindo dados da tabela `tblusuario`
--

INSERT INTO `tblusuario` (`idusuario`, `usuario`, `fone`, `login`, `senha`, `perfil`) VALUES
(1, 'cleyton', '40028922', 'admin', 'admin', 'admin'),
(2, 'user', '2199999999', 'user', 'user', 'user'),
(5, 'naruto', '41214545', 'hokage', '123', 'admin');

-- --------------------------------------------------------

--
-- Estrutura da tabela `tblvendas`
--

CREATE TABLE `tblvendas` (
  `idvendas` int(10) NOT NULL,
  `produto` varchar(50) NOT NULL,
  `valor` int(50) NOT NULL,
  `quantidade` int(50) NOT NULL,
  `total` int(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Extraindo dados da tabela `tblvendas`
--

INSERT INTO `tblvendas` (`idvendas`, `produto`, `valor`, `quantidade`, `total`) VALUES
(1, 'camisa adidas', 59, 1, 0),
(2, 'bermuda adidas', 59, 1, 59),
(3, 'tênis readle', 300, 1, 300),
(4, 'chinelo adidas', 155, 2, 310),
(5, 'blusa', 55, 3, 165),
(6, 'casaco', 350, 1, 350),
(7, 'blusa regata nike', 390, 2, 780),
(8, 'blusa adidas regata', 400, 2, 800);

--
-- Índices para tabelas despejadas
--

--
-- Índices para tabela `tblcliente`
--
ALTER TABLE `tblcliente`
  ADD PRIMARY KEY (`idcliente`);

--
-- Índices para tabela `tblestoque`
--
ALTER TABLE `tblestoque`
  ADD PRIMARY KEY (`idestoque`);

--
-- Índices para tabela `tblfornecedor`
--
ALTER TABLE `tblfornecedor`
  ADD PRIMARY KEY (`idfornecedor`);

--
-- Índices para tabela `tblperfil`
--
ALTER TABLE `tblperfil`
  ADD PRIMARY KEY (`idperfil`);

--
-- Índices para tabela `tblproduto`
--
ALTER TABLE `tblproduto`
  ADD PRIMARY KEY (`idproduto`);

--
-- Índices para tabela `tblusuario`
--
ALTER TABLE `tblusuario`
  ADD PRIMARY KEY (`idusuario`);

--
-- Índices para tabela `tblvendas`
--
ALTER TABLE `tblvendas`
  ADD PRIMARY KEY (`idvendas`);

--
-- AUTO_INCREMENT de tabelas despejadas
--

--
-- AUTO_INCREMENT de tabela `tblcliente`
--
ALTER TABLE `tblcliente`
  MODIFY `idcliente` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT de tabela `tblestoque`
--
ALTER TABLE `tblestoque`
  MODIFY `idestoque` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de tabela `tblfornecedor`
--
ALTER TABLE `tblfornecedor`
  MODIFY `idfornecedor` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT de tabela `tblperfil`
--
ALTER TABLE `tblperfil`
  MODIFY `idperfil` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT de tabela `tblproduto`
--
ALTER TABLE `tblproduto`
  MODIFY `idproduto` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- AUTO_INCREMENT de tabela `tblusuario`
--
ALTER TABLE `tblusuario`
  MODIFY `idusuario` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT de tabela `tblvendas`
--
ALTER TABLE `tblvendas`
  MODIFY `idvendas` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
