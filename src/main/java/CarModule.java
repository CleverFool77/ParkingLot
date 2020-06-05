import com.google.common.collect.HashBiMap;
import com.google.common.collect.Lists;
import com.google.inject.AbstractModule;
import com.google.inject.Inject;
import com.google.inject.Provides;
import com.google.inject.Singleton;
import com.google.inject.assistedinject.FactoryModuleBuilder;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Map;

public class CarModule extends AbstractModule {

  @Override
  protected void configure() {
    // bind(Car.class).to(CarImpl.class);
    install(new FactoryModuleBuilder().implement(Car.class, CarImpl.class).build(CarFactory.class));
  }
}