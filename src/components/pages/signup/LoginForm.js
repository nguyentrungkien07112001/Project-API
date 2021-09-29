import axios from 'axios';
import React, { useState, useEffect} from 'react';
import LValidation from './LValidation';
import './SignupForm.css';

const LoginForm = ({submitForm}) => {
    
    const [values, setValues] = useState({
        username: "",
        password: "",
    });

    const [errors, setErrors] = useState({});
    const[dataIsCorrect, setDataIsCorrect] = useState(false);

    const handleChange = (event) => {
        setValues({
            ...values,
            [event.target.name]: event.target.value,
        });
    };

    const handleFormSubmit = (event) => {
        event.preventDefault();
        setErrors(LValidation(values));
        // setDataIsCorrect(true);

        var bodyFormData = new FormData();
        bodyFormData.append('username', values.username);
        bodyFormData.append('password', values.passowrd);
        
        // const data = {
        //     username: values.username,
        //     password: values.password
        // }

        axios.post('http://localhost:8080/api/v1/login', bodyFormData)
            .then(res => {
                console.log(res);
                setDataIsCorrect(true);
            }).catch(err => {
                console.log(err)
            })

    };

    useEffect(() =>  {
        if (Object.keys(errors).length === 0 && dataIsCorrect) {
         submitForm(true);
        }
    }, [errors]);

    return (
        <div className='container'>
            <div className="app-wrapper">
                <div>
                    <h2 className="title">Đăng nhập</h2>
                </div>
                <form className="form-wrapper">
                    <div className="username">
                    <label className="label">Username</label>
                        <input 
                            className="input" 
                            type="username" 
                            name="username"
                            value={values.username}
                            onChange={handleChange}
                        />
                        {errors.username && <p className="error">{errors.username}</p>}
                    </div>
                    <div className="password">
                    <label className="label">Mật khẩu</label>
                        <input 
                            className="input" 
                            type="password" 
                            name="password"
                            value={values.password}
                            onChange={handleChange}
                        />
                        {errors.password && <p className="error">{errors.password}</p>}
                    </div>
                    <div>
                        <button className='submit' onClick={handleFormSubmit}>Đăng nhập</button>
                    </div>
                </form>
            </div>
        </div>
    )
};

export default LoginForm;
