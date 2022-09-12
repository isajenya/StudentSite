import React, {useEffect, useState} from 'react';
import TextField from '@mui/material/TextField';
import { Container, Paper, Button} from '@mui/material';
import { ClassNames } from '@emotion/react';

export default function Student() {
    const paperStyle = {padding: '50px 20px', width:600, margin: 'auto'};
    const [name, setName] = useState('');
    const[address, setAddress] = useState('');
    const[students, setStudents] = useState([]);

    const handleClick = (e) => {
        e.preventDefault()
        const student = {name, address}
        console.log(student)
        fetch("http://localhost:8080/student/add", {
        method:"Post",
        headers:{"Content-Type": "application/json"},
        body:JSON.stringify(student)
        }).then(() => {
            console.log("New student is added")
    })
    }

    useEffect(()=>{
        fetch("http://localhost:8080/student/getAll")
        .then(res=>res.json())
        .then((result)=>{
          setStudents(result);
        }
      )
      },[])
    

  return (
    <Container
      sx={{
        '& > :not(style)': { m: 1 },
      }}
      noValidate
      autoComplete="off"
    >
         <Paper elevation={3} style={paperStyle}>
         <h1>Add student</h1>

        <form className={ClassNames.root} noValidate autoCapitalize='off'>

      <TextField id="outlined-basic" label="Student Name" variant="outlined" fullWidth
      value={name} 
      onChange={(t) => setName(t.target.value)}
      />
      <TextField id="outlined-basic" label="Student Address" variant="outlined" fullWidth 
      value={address} 
      onChange = {(t) => setAddress(t.target.value)}
      />

    
     <Button variant="contained" onClick={handleClick}>
        Submit
        </Button>
        </form>
   
   </Paper>
   <h1>Students</h1>

   <Paper elevation={3} style={paperStyle}>

     {students.map(student=>(
       <Paper elevation={6} style={{margin:"10px",padding:"15px", textAlign:"left"}} key={student.id}>
        Id:{student.id}<br/>
        Name:{student.name}<br/>
        Address:{student.address}

       </Paper>
     ))
}


   </Paper>



   </Container>
 );
}