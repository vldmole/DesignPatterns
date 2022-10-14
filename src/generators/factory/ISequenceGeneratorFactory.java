package generators.factory;

import generators.ISequenceGenerator;

public interface ISequenceGeneratorFactory
{
	ISequenceGenerator createGenerator(String sequenceName);
}
