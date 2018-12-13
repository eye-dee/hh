{
  function() {
    this.name.split(' ').forEach((el) => emit(el, 1));
  },
  function(key, values) {
    return Array.sum(values)
  },
  {
    "out": "map_reduce_example"
  }
}