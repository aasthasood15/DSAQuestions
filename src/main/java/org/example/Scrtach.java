/*
%-------------------------
        % Resume in Latex
% Author: Shakra Shamim
%------------------------

        \documentclass[letterpaper,11pt]{article}

        \usepackage{latexsym}
\usepackage[empty]{fullpage}
        \usepackage{titlesec}
\usepackage{marvosym}
\usepackage[usenames,dvipsnames]{color}
        \usepackage{verbatim}
\usepackage{enumitem}
\usepackage[hidelinks]{hyperref}
        \usepackage{fancyhdr}
\usepackage[english]{babel}
        \usepackage{tabularx}
\usepackage{fontawesome5}
\usepackage{multicol}
\setlength{\multicolsep}{-3.0pt}
        \setlength{\columnsep}{-1pt}
        \input{glyphtounicode}

\pagestyle{fancy}
\fancyhf{}
\fancyfoot{}
\renewcommand{\headrulewidth}{0pt}
        \renewcommand{\footrulewidth}{0pt}

        \addtolength{\oddsidemargin}{-0.6in}
        \addtolength{\evensidemargin}{-0.5in}
        \addtolength{\textwidth}{1.19in}
        \addtolength{\topmargin}{-.7in}
        \addtolength{\textheight}{1.4in}

        \urlstyle{same}
\raggedbottom
\raggedright
\setlength{\tabcolsep}{0in}

        \titleformat{\section}{
        \vspace{-6pt}\scshape\raggedright\large\bfseries
}{}{0em}{}[\color{black}\titlerule \vspace{-5pt}]

        \pdfgentounicode=1

        \newcommand{\resumeItem}[1]{\item\small{{#1 \vspace{-2pt}}}}
        \newcommand{\resumeSubheading}[4]{
        \vspace{-2pt}\item
    \begin{tabular*}{1.0\textwidth}[t]{l@{\extracolsep{\fill}}r}
        \textbf{#1} & \textbf{\small #2} \\
        \textit{\small#3} & \textit{\small #4} \\
        \end{tabular*}\vspace{-6pt}
}
        \newcommand{\resumeProjectHeading}[2]{
        \item
    \begin{tabular*}{1.001\textwidth}{l@{\extracolsep{\fill}}r}
        \small#1 & \textbf{\small #2}\\
        \end{tabular*}\vspace{-6pt}
}
        \newcommand{\resumeItemListStart}{\begin{itemize}}
        \newcommand{\resumeItemListEnd}{\end{itemize}\vspace{-5pt}}
        \newcommand{\resumeSubHeadingListStart}{\begin{itemize}[leftmargin=0.0in, label={}]}
        \newcommand{\resumeSubHeadingListEnd}{\end{itemize}}

        \begin{document}

%----------HEADING----------
        \begin{center}
    {\Huge \scshape Aastha Sood} \\ \vspace{4pt}
    \textbf{\Large \scshape Software Engineer} \\ \vspace{4pt}
    \small \faPhone\ +91-9882005665 ~
        % IMPORTANT: Replace your email in BOTH places inside the line below (mailto and underline)
    \href{mailto:aasthasood779@gmail.com}{\faEnvelope\ \underline{aasthasood779@gmail.com}} ~
        % IMPORTANT: If you change only one email, the clickable link may still point to the old email
    \href{https://www.linkedin.com/in/aastha-sood-a1405b1b4/}{\faLinkedin\ \underline{linkedin.com/in/aastha-sood-a1405b1b4/}}
\end{center}


%-----------SUMMARY-----------
\section{Summary}
    Backend Software Engineer with 5+ years of experience in fintech and banking, specializing in Java, Spring Boot, and microservices. Delivered production-grade solutions on the Airtel Payments platform — including partner onboarding, ISO 20022 financial messaging, and notification systems processing 50K+ transactions daily across 14 countries. Experienced in modernizing legacy XML systems to JWT-secured REST APIs and working across the full backend stack with Kafka, Redis, Hibernate, and Kubernetes.

            %-----------SKILLS-----------
\section{Skills}
\textbf{Languages:}  Java, SQL, PL/SQL, C++  \\
\textbf{Frameworks \& Libraries:} Spring Boot , Spring AOP, Spring State Machine, Hibernate, Microservices, Servlets, JPA, Spring Cloud \\
\textbf{Databases \& Messaging:} Redis, Kafka, Hibernate ORM, MySQL, PostgreSQL, MongoDB, Redis \\
\textbf{APIs \& Architecture:} REST APIs, Microservices Architecture \\
\textbf{Infrastructure \& Tools:} Kubernetes, Git \\
\textbf{Monitoring:} Grafana, Loki, Jaeger, Spring Boot Admin \\
%-----------INTERNSHIP-----------
\section{Experience}
\resumeSubHeadingListStart
  \resumeSubheading
    {Software Engineer}{July 2022 -- Present}
    {Airtel AInternational LLP  (Remote)}{Gurgaon, Haryana}
    \resumeItemListStart
      \resumeItem{ Led migration of critical payment infrastructure to a new partner authentication architecture, achieving \textbf{zero production downtime} and improving security posture across the platform.}
      \resumeItem{\textbf{Migrated 30+ payment microservices} from \textbf{legacy XML APIs to JWT-secured JSON REST APIs}, integrating authorization workflows with downstream credit/debit partner systems and reducing API parsing complexity by \textbf{~40\%.}}
      \resumeItem{Led development of a notification orchestration module on the \textbf{UNO platform}, automating user communication for payment workflows and processing \textbf{50K+ SMS notifications daily.}}
      \resumeItem{Developed and maintained partner onboarding and API integrations on Airtel Payments platform, facilitating Bill Payment, P2P Transactions, Mobile App, and USSD channels across \textbf{14 countries.}}
      \resumeItem{Engineered \textbf{ISO 20022 financial messaging} microservice for switch operations in Rwanda, contributing to NAT Switch and Monetique integrations for voucher creation, redemption, and multi-channel settlement processing.}
      \resumeItem{\textbf{Designed and implemented centralized MasterCode error-mapping framework} to standardize backend error handling and surfaced user-friendly failure messages across payment services; \textbf{streamlined payment API configuration} for partners through new biller onboarding features on Airtel Biller Portal.}
    \resumeItemListEnd
\resumeSubHeadingListEnd
\resumeSubHeadingListStart
  \resumeSubheading
    {Software Engineer}{Jan 2020 -- July 2022}
    {Newgen Software  (Remote)}{Noida, UP}
    \resumeItemListStart
      \resumeItem{Implemented product features for \textbf{banking web application}, translating domain-specific business rules around loan processing into scalable, automated backend workflows that improved system reliability.}
      \resumeItem{Developed workflow automation features for a \textbf{Loan Management System using Java Spring Boot, enabling bank employees to route and process loan files automatically} — reducing manual handoffs across approval stages.}
      \resumeItem{Built and maintained RESTful APIs using Spring Boot to support dynamic loan file routing, ensuring reliable state transitions and facilitating audit-ready processing for bank operations teams.}
      \resumeItem{Collaborated across full software development lifecycle — from \textbf{requirements gathering and feature design to implementation and testing — to enhance banking automation solutions.}}

    \resumeItemListEnd
\resumeSubHeadingListEnd

            %-----------AWARDS-----------
\section{Awards \& Certifications}
\resumeItemListStart
  \resumeItem{\textbf{Certificate of Achievement for outstanding performance in 2025}}
\resumeItemListEnd

            %-----------EDUCATION-----------
\section{Education}
\resumeSubHeadingListStart
  \resumeSubheading
    {BE (Computer Science)}{Graduated: 2020}
    {Chitkara University , Himachal Pradesh}{CGPA: 8.9 / 10}
\resumeSubHeadingListEnd

\end{document}
*/
