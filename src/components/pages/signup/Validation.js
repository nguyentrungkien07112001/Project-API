const Validation = (values) => {

    let errors={};

    if(!values.fullname) {
        errors.fullname="Name is required."
    }

    if(!values.username) {
        errors.username="Username is required."
    }
    
    if(!values.email) {
        errors.email="Email is required."
    } else if(!/\S+@\S+\.\S+/.test(values.email)){
        errors.email="Email is invalid."
    }
    if(!values.password){
        errors.password="Password is required."
    } else if(values.password.length < 5){
        errors.passwrord="Password must be more than five characters."
    }

    return errors;
}

export default Validation
