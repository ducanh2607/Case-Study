class Car {
    constructor(name, color, price, type, image) {
        this._name = name;
        this._color = color;
        this._price = price;
        this._type = type;
        this._image = image;
    }
    get name() {
        return this._name;
    }
    set name(value) {
        this._name = value;
    }
    get color() {
        return this._color;
    }
    set color(value) {
        this._color = value;
    }
    get price() {
        return this._price;
    }
    set price(value) {
        this._price = value;
    }
    get type() {
        return this._type;
    }
    set type(value) {
        this._type = value;
    }
    get image() {
        return this._image;
    }
    set image(value) {
        this._image = value;
    }
}