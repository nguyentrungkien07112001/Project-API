import React from 'react';
import { Link } from 'react-router-dom';

function CardItem(props) {
    return (
        <>
            <li className='cards__item'>
                <Link className='cards__item__link' to={props.path}>
                    <figure className='cards__item__pic-wrap' data-category={props.label}>
                        <img src ={props.src} alt='Random' className='cards__item__img'/>
                    </figure>
                    <div className='cards__item__info'>
                        <h5 className='cards__item__text'>{props.text}</h5>
                        <p className='cards__item__creator'>Người tạo: {props.creator}</p>
                        <p className='cards__item__progress'>Tiến độ: {props.progress}</p>
                    </div>
                </Link>
            </li>
        </>
    )
}

export default CardItem
